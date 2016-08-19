import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static long n, h, a, b, c, d, e;

  static long best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    h = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
    d = sc.nextInt(); e = sc.nextInt();

    long min = INF;
    for(long i = 0; i <= n; i++){
      long val = (e * n - (e + b) * i - h);
      long j = val / (e + d);
      for(long k = j - 2; k <= j + 3; k++){
        if(k < 0){
          k = 0;
        }
        if(i + k <= n && h - e * (n - i - k) + b * i + d * k > 0){
          min = Math.min(min, a * i + c * k);
        }
      }
    }

    System.out.println(min);
  }
}
