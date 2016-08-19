import java.util.Scanner;

public class Main {
  static final long MOD = 1000000007;
  static int n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();

    long sum = 0;
    for(int i = 1; i <= n; i++){
      sum = (sum +(long)i / gcd(i, k) * (long)k) % MOD;
    }

    System.out.println(sum);
  }

  private static int gcd(int a, int b){
    if(a == 0){
      return b;
    }
    return gcd(b % a, a);
  }
}
