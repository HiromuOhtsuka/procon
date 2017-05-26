import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static long[] a;
  static final long MOD = 1000000007;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long[] pow = new long[n + 1];
    pow[0] = 1;
    for(int i = 1; i <= n; i++){
      pow[i] = (pow[i - 1] * 2) % MOD;
    }

    sort(a);
    long sum = 0;
    for(int i = 0; i + 1 < n; i++){
      long d = a[i + 1] - a[i];
      long m = (pow[i + 1] - 1) * (pow[n - (i + 1)] - 1) % MOD;
      sum = (sum + (d * m) % MOD) % MOD;
    }

    System.out.println(sum);
  }

  private static void sort(long[] a){
    Long[] b = new Long[a.length];
    for(int i = 0; i < a.length; i++){
      b[i] = a[i];
    }
    Arrays.sort(b);
    for(int i = 0; i < b.length; i++){
      a[i] = b[i];
    }
  }
}
