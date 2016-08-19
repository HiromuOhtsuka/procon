import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int[][] b, c;
  static int[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int sum = 0;
    b = new int[2][3];
    for(int i = 0; i < 2; i++){
      for(int j = 0; j < 3; j++){
        b[i][j] = sc.nextInt();
        sum += b[i][j];
      }
    }
    c = new int[3][2];
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 2; j++){
        c[i][j] = sc.nextInt();
        sum += c[i][j];
      }
    }

    table = new int[3][3];
    int sum1 = rec(true);
    int sum2 = sum - sum1;

    System.out.println(sum1);
    System.out.println(sum2);
  }

  private static int rec(boolean f){
    int score = (f ? -INF : INF);
    boolean end = true;
    for(int y = 0; y < 3; y++){
      for(int x = 0; x < 3; x++){
        if(table[y][x] == 0){
          end = false;

          if(f){
            table[y][x] = 1;
          }
          else{
            table[y][x] = -1;
          }

          int s = rec(!f);

          table[y][x] = 0;

          if(f){
            score = Math.max(score, s);
          }
          else{
            score = Math.min(score, s);
          }
        }
      }
    }

    if(end){
      score = 0;
      for(int y = 0; y < 2; y++){
        for(int x = 0; x < 3; x++){
          if(table[y][x] == table[y + 1][x]){
            score += b[y][x];
          }
        }
      }

      for(int y = 0; y < 3; y++){
        for(int x = 0; x < 2; x++){
          if(table[y][x] == table[y][x + 1]){
            score += c[y][x];
          }
        }
      }
    }

    return score;
  }
}
