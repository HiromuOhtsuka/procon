import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static long ww;
  static int[] w, v;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    ww = sc.nextInt();
    w = new int[n];
    v = new int[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.nextInt();
      v[i] = sc.nextInt();
    }

    int[][][] dp = new int[n + 1][n + 1][3 * n + 1];
    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= n; j++){
        Arrays.fill(dp[i][j], -INF);
      }
    }

    dp[0][0][0] = 0;
    for(int i = 1; i <= n; i++){
      for(int j = 0; j <= n; j++){
        for(int k = 0; k <= 3 * n; k++){
          if(j - 1 >= 0 && j <= i && k - (w[i - 1] - w[0]) >= 0){
            if(DEBUG){
              System.out.println("in");
            }
            dp[i][j][k] = Math.max(
                dp[i - 1][j - 1][k - (w[i - 1] - w[0])] + v[i - 1], dp[i - 1][j][k]);
          }
          else{
            dp[i][j][k] = dp[i - 1][j][k];
          }
          if(DEBUG){
            System.out.println("dp[" + i + "][" + j + "][" + k + "] = " + dp[i][j][k]);
          }
        }
      }
    }

    int max = 0;
    for(int i = 1; i <= n; i++){
      for(int j = 0; j <= 3 * n; j++){
        if((long)w[0] * (long)i + j <= ww){
          max = Math.max(max, dp[n][i][j]);
        }
      }
    }

    System.out.println(max);
  }
}
