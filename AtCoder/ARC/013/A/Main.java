import java.util.Scanner;

public class Main {
  static int n, m, l, p, q, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); l = sc.nextInt();
    p = sc.nextInt(); q = sc.nextInt(); r = sc.nextInt();

    int max = Math.max(push(p, q, r), push(r, q, p));
    max = Math.max(max, Math.max(push(q, p, r), push(r, p, q)));
    max = Math.max(max, Math.max(push(p, r, q), push(q, r, p)));

    System.out.println(max);
  }

  private static int push(int p, int q, int r){
    if(r > l || q > m || p > n){
      return 0;
    }
    return (m / q) * (n / p) * (l / r);
  }
}
