import java.util.Scanner;

public class Main {
  public static final double INF = Double.MAX_VALUE;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int l = sc.nextInt(), x = sc.nextInt(),
      y = sc.nextInt(), s = sc.nextInt(), d = sc.nextInt();

    double ans = INF;
    if(d > s){
      ans = (double)(d - s) / (x + y);
      if(y - x > 0){
        ans = Math.min(ans, (double)(s + (l - d)) / (y - x));
      }
    }
    else{
      if(y - x > 0){
        ans = (double)(s - d) / (y - x);
      }
      ans = Math.min(ans, (double)(l - s + d) / (x + y));
    }

    System.out.printf("%.6f\n", ans);
  }
}
