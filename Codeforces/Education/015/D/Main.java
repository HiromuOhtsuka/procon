import java.util.Scanner;

public class Main {
  static long d, k, a, b, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    d = sc.nextLong();
    k = sc.nextInt(); a = sc.nextInt(); b = sc.nextInt();
    t = sc.nextInt();

    long ans = 0;
    ans += Math.min(k, d) * a;
    d -= Math.min(k, d);
    long c = a * k + t;
    long w = b * k;
    if(c <= w){
      ans += c * (d / k);
      d -= (d / k) * k;
      if(d > 0){
        c = t + d * a;
        w = d * b;
        ans += Math.min(c, w);
      }
    }
    else{
      ans += d * b;
    }

    System.out.println(ans);
  }
}
