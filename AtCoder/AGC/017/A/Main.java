import java.util.Scanner;

public class Main{
  static int n, p;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    p = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long[][] dp = new long[n + 1][2];
    dp[0][0] = 1;
    for(int i = 1; i <= n; i++){
      if(a[i - 1] % 2 == 0){
        dp[i][0] = dp[i - 1][0] * 2;
        dp[i][1] = dp[i - 1][1] * 2;
      }
      else{
        dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
        dp[i][1] = dp[i - 1][1] + dp[i - 1][0];
      }
    }

    System.out.println(dp[n][p]);
  }
}
