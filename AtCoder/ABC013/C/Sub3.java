import java.util.Scanner;

public class Sub3 {
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
    for(int i = 0; i <= n; i++){
      for(int j = 0; j <= n; j++){
        if(i + j > n){
          continue;
        }
        if(h - e * (n - (i + j)) + b * i + d * j > 0){
          min = Math.min(min, a * i + c * j);
        }
      }
    }

    System.out.println(min);
  }
}
