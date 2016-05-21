import java.util.Scanner;

public class Main {
  public static final double INF = Double.MAX_VALUE;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double p = sc.nextDouble();

    double x = (-1.5) / Math.log(2.0) * Math.log(1.5 / (p * Math.log(2)));

    double ans = INF;
    if(x > 0){
      ans = x + p / Math.pow(2.0, x / 1.5);
    }

    if(ans < 0 || ans >= p){
      ans = p;
    }

    System.out.printf("%.8f\n", ans);
  }
}
