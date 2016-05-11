import java.util.Scanner;

public class Main {
  static Point p1, p2;
  static Line p1p2;
  static int q;
  static Point[] points;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double x1 = sc.nextDouble(), y1 = sc.nextDouble(),
      x2 = sc.nextDouble(), y2 = sc.nextDouble();
    p1 = new Point(x1, y1); p2 = new Point(x2, y2);
    q = sc.nextInt();
    points = new Point[q];
    for(int i = 0; i < q; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      points[i] = new Point(x, y);
    }

    p1p2 = new Line(p1, p2);
    for(int i = 0; i < q; i++){
      Point ans = p1p2.reflection(points[i]);
      System.out.printf("%.8f %.8f\n", ans.x, ans.y);
    }
  }
}


class Line {
  Point s, t;

  Line(Point s, Point t){
    this.s = s; this.t = t;
  }

  Point projection(Point p){
    Point st = new Point(t.x - s.x, t.y - s.y),
      sp = new Point(p.x - s.x, p.y - s.y);
    double k = Point.dot(st, sp) / st.norm2();
    return Point.add(s, Point.mul(k, st));
  }

  Point reflection(Point p){
    return Point.add(Point.sub(
      Point.mul(2.0, 
        Point.sub(projection(p), s)),
          new Point(p.x - s.x, p.y - s.y)), s);
  }
}

class Point implements Comparable< Point > {
  static final double EPS = 1e-10;
  double x, y;

  Point(double x, double y){
    this.x = x; this.y = y;
  }

  static Point add(Point v1, Point v2){
    return new Point(v1.x + v2.x, v1.y + v2.y);
  }

  static Point sub(Point v1, Point v2){
    return new Point(v1.x - v2.x, v1.y - v2.y);
  }

  static Point mul(double k, Point v){
    return new Point(k * v.x, k * v.y);
  }

  static Point div(Point v, double d){
    return new Point(v.x / d, v.y / d);
  }

  static double dot(Point p1, Point p2){
    return p1.x * p2.x + p1.y * p2.y;
  }

  double norm(){
    return Math.sqrt(x * x + y * y);
  }

  double norm2(){
    return x * x + y * y;
  }

  @Override
  public boolean equals(Object obj){
    if(!(obj instanceof Point)){
      return false;
    }
    Point p = (Point)obj;
    return Math.abs(x - p.x) < EPS &&
      Math.abs(y - p.y) < EPS;
  }

  @Override
  public int compareTo(Point p){
    if(equals(p)){
      return 0;
    }

    if(Math.abs(x - p.x) < EPS){ // x == p.x
      if(y < p.y){
        return -1;
      }
      else{
        return 1;
      }
    }
    else{
      if(x < p.x){
        return -1;
      }
      else{
        return 1;
      }
    }
  }
}
