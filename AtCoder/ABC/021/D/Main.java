import java.util.Scanner;

public class Main {
  static final long MOD = 1000000007;
  static int n, k;
  static long[] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    dp = new long[n + 1];
    for(int i = 1; i <= n; i++){
      dp[i] = i;
    }

    for(int i = 2; i <= k; i++){
      for(int j = 1; j <= n; j++){
        dp[j] = (dp[j] + dp[j - 1]) % MOD;
      }
    }

    System.out.println(dp[n]);
  }
}
