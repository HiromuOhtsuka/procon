import java.util.Scanner;

public class Main {
  static int n, a;
  static int[] x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt();
    x = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }

    long[][][] dp = new long[n + 1][n + 1][n * 50 + 1];
    dp[0][0][0] = 1;
    for(int i = 1; i <= n; i++){
      for(int j = 0; j <= n; j++){
        for(int k = 0; k < dp[i][j].length; k++){
          if(j - 1 >= 0 && k - x[i - 1] >= 0){
            dp[i][j][k] += dp[i - 1][j - 1][k - x[i - 1]];
          }
          dp[i][j][k] += dp[i - 1][j][k];
        }
      }
    }

    long count = 0;
    for(int i = 1; i <= n; i++){
      int tar = i * a;
      count += dp[n][i][tar];
    }

    System.out.println(count);
  }
}
