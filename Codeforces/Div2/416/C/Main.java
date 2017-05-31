import java.util.Scanner;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n;
  static int[] a;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[] pos0 = new int[n];
    int[] pos1 = new int[n];
    Arrays.fill(pos0, -1);
    Arrays.fill(pos1, n);
    for(int i = 0; i < n; i++){
      for(int j = i - 1; j >= 0; j--){
        if(a[i] == a[j]){
          pos0[i] = j;
          break;
        }
      }
      for(int j = i + 1; j < n; j++){
        if(a[i] == a[j]){
          pos1[i] = j;
          break;
        }
      }
    }

    long[] dp = new long[n + 1];
    for(int i = 1; i <= n; i++){
      long result = 0;
      long val = 0;
      int min = n;
      int max = -1;
      for(int k = 1; k <= i; k++){
        if(i - k >= 0){
          if(pos0[i - k] == -1){
            val ^= a[i - k];
          }
          else{
            min = Math.min(min, pos0[i - k]);
          }
          if(pos1[i - k] != n){
            max = Math.max(max, pos1[i - k]);
          }
          if(max < i && min >= i - k){
            result = Math.max(result, dp[i - k] + val);
          }
          else{
            result = Math.max(result, dp[i - k]);
          }
        }
      }
      dp[i] = result;
    }

    if(DEBUG){
      for(int i = 0; i <= n; i++){
        System.out.println("dp[" + i + "] = " + dp[i]);
      }
    }

    System.out.println(dp[n]);
  }
}
