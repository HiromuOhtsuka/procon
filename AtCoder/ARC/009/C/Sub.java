import java.util.Scanner;

public class Sub {
  static int n, k;
  static int[] perm;
  static boolean[] used;

  static int best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();

    if(n > 8){
      return;
    }

    perm = new int[n];
    used = new boolean[n];
    backTrack(0);

    System.out.println(best);
  }

  private static void backTrack(int i){
    int count = 0;
    for(int j = 0; j < i; j++){
      if(perm[j] != j){
        ++count;
      }
    }
    if(count > k){
      return;
    }
    if(i == n){
      if(count == k){
        ++best;
      }
      return;
    }
    for(int j = 0; j < n; j++){
      if(!used[j]){
        used[j] = true;
        perm[i] = j;
        backTrack(i + 1);
        used[j] = false;
      }
    }
  }
}
