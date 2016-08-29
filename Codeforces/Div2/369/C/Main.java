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
    boolean check = true;
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
      if(c[i] == 0){
        check = false;
      }
    }
    p = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        p[i][j] = sc.nextInt();
      }
    }
    if(check){
      if(beauty(c, n) == k){
        System.out.println(0);
      }
      else{
        System.out.println(-1);
      }
      return;
    }

    long[][][] dp = new long[n + 1][k + 1][m + 1];

    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= k; j++){
        Arrays.fill(dp[i][j], INF);
      }
    }
    if(c[0] != 0){
      for(int i = 1; i <= m; i++){
        dp[1][1][i] = 0;
      }
    }
    else{
      for(int i = 0; i < m; i++){
        dp[1][1][i + 1] = p[0][i];
      }
    }

    for(int i = 2; i <= n; i++){
      for(int j = 1; j <= k; j++){
        if(c[i - 1] != 0){
          long val = dp[i - 1][j][c[i - 1]];
          for(int l = 1; l <= m; l++){
            if(c[i - 1] == l){
              continue;
            }
            val = Math.min(val, dp[i - 1][j - 1][l]);
          }
          dp[i][j][c[i - 1]] = val;
        }
        else{
          for(int l = 1; l <= m; l++){
            long val = dp[i - 1][j][l] + p[i - 1][l - 1];
            for(int o = 1; o <= m; o++){
              if(o == l){
                continue;
              }
              val = Math.min(val, dp[i - 1][j - 1][o] + p[i - 1][l - 1]);
            }
            dp[i][j][l] = val;
          }
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

  private static long beauty(int[] a, int n){
    long count = 0;
    int s = 0, t = 0;
    for(;;){
      t = s;
      while(t + 1 < n && a[t] == a[t + 1]){
        ++t;
      }
      ++count;
      s = t + 1;
      if(s >= n){
        break;
      }
    }
    return count;
  }
}
