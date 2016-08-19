import java.util.Scanner;

public class Main {
  static double txa, tya, txb, tyb, t, v;
  static int n;
  static double[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    txa = sc.nextDouble();  tya = sc.nextDouble();
    txb = sc.nextDouble();  tyb = sc.nextDouble();
    t = sc.nextDouble();  v = sc.nextDouble();
    n = sc.nextInt();
    x = new double[n];  y = new double[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextDouble(); y[i] = sc.nextDouble();
    }

    for(int i = 0; i < n; i++){
      double d = dist(txa, tya, x[i], y[i]) + dist(x[i], y[i], txb, tyb);
      if(d <= v * t){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }

  private static double dist(double x1, double y1, double x2, double y2){
    return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
  }
}
