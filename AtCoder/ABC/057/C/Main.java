import java.util.Scanner;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();

    int min = INF;
    for(long a = 1; a * a <= n; a++){
      if(n % a == 0){
        min = Math.min(min, f(a, n / a));
      }
    }

    System.out.println(min);
  }

  private static int f(long a, long b){
    int ka = 0, kb = 0;
    while(a != 0){
      ka++;
      a /= 10;
    }
    while(b != 0){
      kb++;
      b /= 10;
    }
    return Math.max(ka, kb);
  }
}
