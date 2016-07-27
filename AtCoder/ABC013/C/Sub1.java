import java.util.Scanner;

public class Sub1 {
  static final long INF = Long.MAX_VALUE / 2;
  static long n, h, a, b, c, d, e;

  static long best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    if(n > 10){
      return;
    }
    h = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();
    d = sc.nextInt(); e = sc.nextInt();

    best = INF;
    backTrack(0, 0, h);

    System.out.println(best);
  }

  private static void backTrack(int i, long cost, long sum){
    if(sum <= 0){
      return;
    }
    if(i == n){
      best = Math.min(best, cost);
      return;
    }
    backTrack(i + 1, cost + a, sum + b);
    backTrack(i + 1, cost + c, sum + d);
    backTrack(i + 1, cost, sum - e);
  }
}
