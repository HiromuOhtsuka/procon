import java.util.Scanner;

public class Main {
  static long x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String[] ls = sc.next().split("/");
    x = Long.parseLong(ls[0]);  y = Long.parseLong(ls[1]);

    long d = gcd(x, y);
    x /= d; y /= d;

    boolean flag = false;
    long r = x * 2 / y;
    for(long n = r; n <= r + 1; n++){
      if(n % y != 0){
        continue;
      }
      long s = x * (n / y);
      long m = n * (n + 1) / 2 - s;
      if(1 <= m && m <= n){
        flag = true;
        System.out.println(n + " " + m);
      }
    }

    if(!flag){
      System.out.println("Impossible");
    }
  }

  private static long gcd(long a, long b){
    if(a == 0){
      return b;
    }
    return gcd(b % a, a);
  }
}
