import java.util.Scanner;

public class Main {
  static final long MOD = 1000000007;
  static long a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextLong(); b = sc.nextLong();
    c = sc.nextLong();

    long x = (a * b) % MOD;
    x = (x * c) % MOD;

    System.out.println(x);
  }
}
