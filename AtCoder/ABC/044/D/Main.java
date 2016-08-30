import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static long n, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();  s = sc.nextLong();

    long ans = INF;
    if(n == s){
      ans = n + 1;
    }
    for(long b = 2; b * b <= n; b++){
      if(f(b, n) == s){
        ans = b;
        break;
      }
    }
    if(ans == INF){
      for(long p = 1; p * p <= n; p++){
        long b = (n - s) / p + 1;
        if(b < 2){
          continue;
        }
        if(f(b, n) == s){
          ans = Math.min(ans, b);
        }
      }
    }

    if(ans == INF){
      System.out.println(-1);
    }
    else{
      System.out.println(ans);
    }
  }

  private static long f(long b, long n){
    if(n < b){
      return n;
    }
    return f(b, n / b) + (n % b);
  }
}
