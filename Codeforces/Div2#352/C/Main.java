import java.util.Scanner;

public class Main {
  static int n;
  static Point a, b, t;
  static Point[] points;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double xa = sc.nextDouble(), ya = sc.nextDouble();
    double xb = sc.nextDouble(), yb = sc.nextDouble();
    double xt = sc.nextDouble(), yt = sc.nextDouble();

    a = new Point(xa, ya);
    b = new Point(xb, yb);
    t = new Point(xt, yt);

    n = sc.nextInt();
    points = new Point[n];
    for(int i = 0; i < n; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      points[i] = new Point(x, y);
    }

    double sum = 0.0;

    double dd = 0.0;
    int ddi = -1;
    boolean isA = false;
    for(int i = 0; i < n; i++){
      double d = Point.distance(points[i], t);
      if(dd < d - Point.distance(points[i], a)){
        dd = d - Point.distance(points[i], a);
        ddi = i;
        isA = true;
      }
      if(dd < d - Point.distance(points[i], b)){
        dd = d - Point.distance(points[i], b);
        ddi = i;
        isA = false;
      }
      sum += 2.0 * d;
    }
    sum -= dd;

    if(!isA){
      b = a;
    }

    dd = 0.0;
    for(int i = 0; i < n; i++){
      if(i == ddi){
        continue;
      }
      double d = Point.distance(points[i], t);
      dd = Math.max(dd, d - Point.distance(points[i], b));
    }
    sum -= dd;

    System.out.printf("%.6f\n", sum);
  }

  static class Point {
    double x, y;

    Point(double x, double y){
      this.x = x; this.y = y;
    }

    static double distance(Point p0, Point p1){
      double dx = p1.x - p0.x,
        dy = p1.y - p0.y;
      return Math.sqrt(dx * dx + dy * dy);
    }
  }

}
