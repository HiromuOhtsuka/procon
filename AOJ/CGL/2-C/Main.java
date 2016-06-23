import java.util.Scanner;

public class Main {
  static int q;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    q = sc.nextInt();
    for(int t = 0; t < q; t++){
      double x0 = sc.nextDouble(), y0 = sc.nextDouble(),
        x1 = sc.nextDouble(), y1 = sc.nextDouble(),
        x2 = sc.nextDouble(), y2 = sc.nextDouble(),
        x3 = sc.nextDouble(), y3 = sc.nextDouble();
      Segment s1 = new Segment(new Point(x0, y0), new Point(x1, y1));
      Segment s2 = new Segment(new Point(x2, y2), new Point(x3, y3));

      Point cross = Segment.intersection(s1, s2);

      System.out.printf("%.8f %.8f\n", cross.x, cross.y);
    }
  }
}

class Segment {
  static final double EPS = 1e-10;
  Point s, t;

  Segment(Point s, Point t){
    this.s = s; this.t = t;
  }

  boolean intersection(Segment s){
    return Point.ccw(this.s, this.t, s.s) * 
      Point.ccw(this.s, this.t, s.t) <= 0 &&
      Point.ccw(s.s, s.t, this.s) * 
      Point.ccw(s.s, s.t, this.t) <= 0;
  }

  static Point intersection(Segment s1, Segment s2){
    Point b = Point.sub(s2.t, s2.s);
    double d1 = Math.abs(Point.cross(b, Point.sub(s1.s, s2.s)));
    double d2 = Math.abs(Point.cross(b, Point.sub(s1.t, s2.s)));
    double t = d1 / (d1 + d2);
    return Point.add(s1.s, Point.mul(t, Point.sub(s1.t, s1.s)));
  }
}

class Point implements Comparable< Point > { 
  static final double EPS = 1e-10; 
  static final int COUNTER_CLOCKWISE = 1;
  static final int CLOCKWISE = -1;
  static final int ONLINE_BACK = 2;
  static final int ONLINE_FRONT = -2;
  static final int ON_SEGMENT = 0;
  double x, y;

  Point(double x, double y){
    this.x = x; this.y = y;
  }

  static Point add(Point p1, Point p2){
    return new Point(p1.x + p2.x, p1.y + p2.y);
  }

  static Point sub(Point p1, Point p2){
    return new Point(p1.x - p2.x, p1.y - p2.y);
  }

  static Point mul(double k, Point p){
    return new Point(k * p.x, k * p.y);
  }

  static Point div(Point p, double d){
    return new Point(p.x / d, p.y / d);
  }

  static double dot(Point p1, Point p2){
    return p1.x * p2.x + p1.y * p2.y;
  }

  static double cross(Point p1, Point p2){
    return p1.x * p2.y - p1.y * p2.x;
  }

  static double distance(Point p0, Point p1){
    double dx = p1.x - p0.x,
           dy = p1.y - p0.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  static int ccw(Point p0, Point p1, Point p2){
    Point a = sub(p1, p0), b = sub(p2, p0);
    if(cross(a, b) > EPS){
      return COUNTER_CLOCKWISE;
    }
    if(cross(a, b) < -EPS){
      return CLOCKWISE;
    }
    if(dot(a, b) < -EPS){
      return ONLINE_BACK;
    }
    if(a.norm2() < b.norm2()){
      return ONLINE_FRONT;
    }
    return ON_SEGMENT;
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
