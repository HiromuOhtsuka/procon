import java.util.Scanner;

public class Main {
  static long n, a, b, p, q;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();
    a = sc.nextLong(); b = sc.nextLong();
    p = sc.nextLong(); q = sc.nextLong();

    long sum = 0;
    if(a == b){
      sum += n / a * Math.max(p, q);
    }
    else{
      long d = (a * b) / gcd(a, b);
      sum += (n / d) * Math.max(p, q)
        - (n / d) * (p + q)
        + (n / a) * p + (n / b) * q;
    }

    System.out.println(sum);
  }

  private static long gcd(long c, long d){
    if(c == 0){
      return d;
    }
    return gcd(d % c, c);
  }
}
