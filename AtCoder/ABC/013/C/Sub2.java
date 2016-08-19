import java.util.Scanner;

public class Sub2 {
  static final long INF = Long.MAX_VALUE / 2;
  static long n, h, a, b, c, d, e;

  static long best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    if(n > 50){
      return;
    }
    h = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
    d = sc.nextInt(); e = sc.nextInt();

    if(n <= 10 && (b > 50 ||  d > 50 || e > 50)){
      best = INF;
      backTrack(0, 0, h);
      System.out.println(best);
      return;
    }

    final int MAX = 50 * (int)n + (int)h;
    long[][] dp = new long[(int)n + 1][MAX + 1];
    for(int i = 0; i < dp[0].length; i++){
      dp[0][i] = INF;
    }
    dp[0][(int)h] = 0;
    for(int i = 1; i <= n; i++){
      for(int j = 0; j < dp[i].length; j++){
        long min = INF;
        if(j - b > 0){
          min = Math.min(min, dp[i - 1][j - (int)b] + a);
        }
        if(j - d > 0){
          min = Math.min(min, dp[i - 1][j - (int)d] + c);
        }
        if(j > 0 && j + e < dp[i].length){
          min = Math.min(min, dp[i - 1][j + (int)e]);
        }
        dp[i][j] = min;
      }
    }

    long min = INF;
    for(int i = 0; i < dp[(int)n].length; i++){
      min = Math.min(min, dp[(int)n][i]);
    }

    System.out.println(min);
  }

  private static void backTrack(int i, long cost, long sum){
    if(sum <= 0){
      return;
    }
    if(i == n){
      best = Math.min(best, cost);
      return;
    }
    backTrack(i + 1, cost + a, sum + b);
    backTrack(i + 1, cost + c, sum + d);
    backTrack(i + 1, cost, sum - e);
  }
}
