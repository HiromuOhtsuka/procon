import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, m, k;
  static int[] c;
  static int[][] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
    }
    p = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        p[i][j] = sc.nextInt();
      }
    }

    long[][][] dp = new long[n + 1][k + 1][m + 1];

    for(int i = 0; i < dp.length; i++){
      for(int j = 0; j < dp[i].length; j++){
          Arrays.fill(dp[i][j], INF);
      }
    }
    if(c[0] == 0){
      for(int i = 1; i <= m; i++){
        dp[1][1][i] = p[0][i - 1];
      }
    }
    else{
      dp[1][1][c[0]] = 0;
    }

    for(int i = 2; i <= n; i++){
      for(int j = 1; j <= k; j++){
        if(c[i - 1] == 0){
          for(int l = 1; l <= m; l++){
            long val = dp[i - 1][j][l] + p[i - 1][l - 1];
            for(int o = 1; o <= m; o++){
              if(l == o){
                continue;
              }
              val = Math.min(val, dp[i - 1][j - 1][o] + p[i - 1][l - 1]);
            }
            dp[i][j][l] = val;
          }
        }
        else{
          for(int l = 0; l <= m; l++){
            dp[i][j][l] = INF;
          }
          long val = dp[i - 1][j][c[i - 1]];
          for(int o = 1; o <= m; o++){
            if(c[i - 1] == o){
              continue;
            }
            val = Math.min(val, dp[i - 1][j - 1][o]);
          }
          dp[i][j][c[i - 1]] = val;
        }
      }
    }

    long min = INF;
    for(int i = 1; i <= m; i++){
      min = Math.min(min, dp[n][k][i]);
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }
}
