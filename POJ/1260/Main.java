import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int test, n;
  static int[] a, p;
  static int[] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    test = sc.nextInt();
    for(int t = 0; t < test; t++){
      n = sc.nextInt();
      a = new int[n]; p = new int[n];
      for(int i = 0; i < n; i++){
        a[i] = sc.nextInt();  p[i] = sc.nextInt();
      }

      dp = new int[n + 1];
      for(int i = 1; i <= n; i++){
        int min = INF;
        for(int k = 0; k < i; k++){
          int sum = 10;
          for(int l = k; l < i; l++){
            sum += a[l];
          }
          min = Math.min(min, dp[k] + sum * p[i - 1]);
        }
        dp[i] = min;
      }

      System.out.println(dp[n]);
    }
  }
}
