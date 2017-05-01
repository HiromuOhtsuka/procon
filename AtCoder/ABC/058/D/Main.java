import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final long MOD = 1_000_000_007;
  static int n, m;
  static long[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    x = new long[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }
    y = new long[m];
    for(int i = 0; i < m; i++){
      y[i] = sc.nextInt();
    }

    long sumX = 0;
    for(int i = 1; i <= n; i++){
      sumX = (((x[i - 1] * (2 * i - n - 1)) % MOD) + sumX) % MOD;
    }
    long sumY = 0;
    for(int i = 1; i <= m; i++){
      sumY = (((y[i - 1] * (2 * i - m - 1)) % MOD) + sumY) % MOD;
    }

    long ans = (sumX * sumY) % MOD;

    System.out.println(ans);
  }
}
