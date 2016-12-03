import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE;
  static long n, a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    long ans = INF;
    if(n % 4 == 0){
      ans = 0;
    }
    else if(n % 4 == 1){
      ans = Math.min(ans, c);
      ans = Math.min(ans, a * 3);
      ans = Math.min(ans, a + b);
    }
    else if(n % 4 == 2){
      ans = Math.min(ans, b);
      ans = Math.min(ans, 2 * a);
      ans = Math.min(ans, 2 * c);
    }
    else if(n % 4 == 3){
      ans = Math.min(ans, a);
      ans = Math.min(ans, c * 3);
      ans = Math.min(ans, b + c);
    }

    System.out.println(ans);
  }
}
