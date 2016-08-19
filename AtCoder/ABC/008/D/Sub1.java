import java.util.Scanner;
import java.util.Arrays;

public class Sub1 {
  static int w, h;
  static int n;
  static int[] x, y;

  static int[] perm;
  static boolean[] used;
  static boolean[][] table;

  static int best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    w = sc.nextInt(); h = sc.nextInt();
    n = sc.nextInt();

    // sub1
    if(n > 8){
      return;
    }

    x = new int[n]; y = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt() - 1; y[i] = sc.nextInt() - 1;
    }
    table = new boolean[h][w];
    perm = new int[n];
    used = new boolean[n];
    best = 0;
    permutation(0);

    System.out.println(best);
  }

  private static void permutation(int i){
    if(i == n){
      best = Math.max(best, check());
      for(int j = 0; j < h; j++){
        Arrays.fill(table[j], false);
      }
      return;
    }
    for(int j = 0; j < n; j++){
      if(!used[j]){
        perm[i] = j;
        used[j] = true;
        permutation(i + 1);
        used[j] = false;
      }
    }
  }

  private static int check(){
    int sum = 0;
    for(int i = 0; i < n; i++){
      int j = perm[i];
      if(!table[y[j]][x[j]]){
        ++sum;
        table[y[j]][x[j]] = true;
      }
      // left
      for(int nx = x[j] - 1; nx >= 0; nx--){
        if(0 <= nx && nx < w){
          if(!table[y[j]][nx]){
            ++sum;
            table[y[j]][nx] = true;
          }
          else{
            break;
          }
        }
      }
      // right
      for(int nx = x[j] + 1; nx < w; nx++){
        if(0 <= nx && nx < w){
          if(!table[y[j]][nx]){
            ++sum;
            table[y[j]][nx] = true;
          }
          else{
            break;
          }
        }
      }
      // up
      for(int ny = y[j] - 1; ny >= 0; ny--){
        if(0 <= ny && ny < h){
          if(!table[ny][x[j]]){
            ++sum;
            table[ny][x[j]] = true;
          }
          else{
            break;
          }
        }
      }
      // down
      for(int ny = y[j] + 1; ny < h; ny++){
        if(0 <= ny && ny < h){
          if(!table[ny][x[j]]){
            ++sum;
            table[ny][x[j]] = true;
          }
          else{
            break;
          }
        }
      }
    }
    return sum;
  }
}
