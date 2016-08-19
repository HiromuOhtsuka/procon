import java.util.Scanner;

public class Main {
  static final double INF = Double.MAX_VALUE / 2;
  static double a, b;
  static int n;
  static double[] x, y, v;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextDouble(); b = sc.nextDouble();
    n = sc.nextInt();
    x = new double[n]; y = new double[n]; v = new double[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextDouble();  y[i] = sc.nextDouble();  v[i] = sc.nextDouble();
    }

    double min = INF;
    for(int i = 0; i < n; i++){
      double dist = Math.sqrt((x[i] - a) * (x[i] - a) + (y[i] - b) * (y[i] - b));
      double time = dist / v[i];
      min = Math.min(min, time);
    }

    System.out.println(min);
  }
}
