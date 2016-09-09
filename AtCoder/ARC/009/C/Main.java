import java.util.Scanner;

public class Main {
  static final long MOD = 1_777_777_777L;
  static long n;
  static int k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong() % MOD;
    k = sc.nextInt();

    long[] dp = new long[k + 1];
    dp[2] = 1;
    for(int i = 3; i <= k; i++){
      dp[i] = ((long)(i - 1) * ((dp[i - 1] + dp[i - 2])) % MOD) % MOD;
    }

    long ans = 1;
    for(long i = n; i >= n - k + 1; i--){
      ans = (ans * i) % MOD;
    }

    for(long i = 2; i <= k; i++){
      ans = (ans * pow(i, MOD - 2)) % MOD;
    }

    ans = (ans * dp[k]) % MOD;

    System.out.println(ans);
  }

  private static long pow(long a, long b){
    long ret = 1, base = a;

    do{
      if((b & 1L) != 0L){
        ret = (ret * base) % MOD;
      }
      base = (base * base) % MOD;
      b >>= 1L;
    }while(b != 0L);

    return ret;
  }
}
