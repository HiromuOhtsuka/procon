import java.util.Scanner;

public class Main{
  static final long MOD = 1_000_000_007;
  static int n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();

    if(Math.abs(n - m) >= 2){
      System.out.println(0);
      return;
    }

    long[] fac = new long[Math.max(n, m) + 1];
    fac[0] = 1;
    for(int i = 1; i <= Math.max(n, m); i++){
      fac[i] = (fac[i - 1] * i) % MOD;
    }

    long ans = (fac[n] * fac[m]) % MOD;
    if(n == m){
      ans = (2L * ans) % MOD;
    }

    System.out.println(ans);
  }
}
