import java.util.Scanner;

public class Main {
  static final long M = 1_000_000_007;
  static int n, m;
  static int[] f;

  static long[] dp, s;
  static int[] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    f = new int[n + 1];
    for(int i = 0; i < n; i++){
      f[i + 1] = sc.nextInt();
    }

    dp = new long[n + 1];
    s = new long[n + 1];
    c = new int[m + 1];
    dp[0] = s[0] = 1;
    int l = 0;
    for(int i = 1; i <= n; i++){
      ++c[f[i]];
      while(l < i && c[f[i]] >= 2){
        c[f[l]]--;
        ++l;
      }
      dp[i] = (M + s[i - 1] - ((l - 2 >= 0) ? s[l - 2] : 0)) % M;
      s[i] = (s[i - 1] + dp[i]) % M;
    }

    System.out.println(dp[n]);
  }
}
