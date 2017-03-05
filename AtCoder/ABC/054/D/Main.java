import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, ma, mb;
  static int[] a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    ma = sc.nextInt();  mb = sc.nextInt();
    a = new int[n];
    b = new int[n];
    c = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    int[][][] dp = new int[n + 1][n * 10 + 1][n * 10 + 1];

    for(int j = 0; j < dp[0].length; j++){
      Arrays.fill(dp[0][j], INF);
    }

    dp[0][0][0] = 0;
    for(int i = 1; i <= n; i++){
      for(int j = 0; j < dp[i].length; j++){
        for(int k = 0; k < dp[i][j].length; k++){
          if(j - a[i - 1] >= 0 && k - b[i - 1] >= 0){
            dp[i][j][k] =
              Math.min(dp[i - 1][j][k], 
                  dp[i - 1][j - a[i - 1]][k - b[i - 1]] + c[i - 1]);
          }
          else{
            dp[i][j][k] = dp[i - 1][j][k];
          }
        }
      }
    }

    int min = INF;
    for(int i = 1; Math.max(i * ma, i * mb) < dp[0][0].length; i++){
      min = Math.min(min, dp[n][i * ma][i * mb]);
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }
}
