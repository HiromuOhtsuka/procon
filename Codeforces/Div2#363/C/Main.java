import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[][] dp = new int[n + 1][3];
    for(int i = 1; i <= n; i++){
      if(a[i - 1] == 0){
        int min = INF;
        for(int j = 0; j < 3; j++){
          min = Math.min(min, dp[i - 1][j]);
        }
        dp[i][1] = dp[i][2] = INF;
        dp[i][0] = min + 1;
      }
      else if(a[i - 1] == 1){
        dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = INF;
      }
      else if(a[i - 1] == 2){
        dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
        dp[i][1] = INF;
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
      }
      else if(a[i - 1] == 3){
        dp[i][0] = Math.min(dp[i - 1][0], Math.min(dp[i - 1][1], dp[i - 1][2])) + 1;
        dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
        dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]);
      }
    }

    int min = INF;
    for(int j = 0; j < 3; j++){
      min = Math.min(min, dp[n][j]);
    }

    System.out.println(min);
  }
}
