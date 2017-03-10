import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static Point[] ps;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    ps = new Point[3];
    for(int i = 0; i < 3; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      ps[i] = new Point(x, y);
    }

    Set< Point > p4s = new TreeSet< >();
    for(int i = 0; i < 3; i++){
      for(int j = i + 1; j < 3; j++){
        int k = 0;
        while(k < 3 && (ps[k].equals(ps[i]) || ps[k].equals(ps[j]))){
          ++k;
        }
        p4s.add(Point.add(ps[j], Point.sub(ps[k], ps[i])));
        p4s.add(Point.add(ps[k], Point.sub(ps[i], ps[j])));
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(p4s.size() + System.lineSeparator());
    for(Point p : p4s){
      sb.append((long)p.x + " " + (long)p.y + System.lineSeparator());
    }

    System.out.print(sb);
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

  /* 内積 */
  static double dot(Point p1, Point p2){
    return p1.x * p2.x + p1.y * p2.y;
  }

  /* 外積 */
  static double cross(Point p1, Point p2){
    return p1.x * p2.y - p1.y * p2.x;
  }

  static double distance(Point p0, Point p1){
    double dx = p1.x - p0.x,
           dy = p1.y - p0.y;
    return Math.sqrt(dx * dx + dy * dy);
  }

  /* 線分p0p1と点p2の位置関係 */
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

  /* ノルムの値（二乗値でない） */
  double norm(){
    return Math.sqrt(x * x + y * y);
  }

  /* ノルムの2乗値 */
  double norm2(){
    return x * x + y * y;
  }

  /* 点pがなす角 */
  static double arg(Point p){
    return Math.atan2(p.y, p.x);
  }

  /* 長さrで，角度rの点の座標 */
  static Point polar(double a, double r){
    return new Point(Math.cos(r) * a, Math.sin(r) * a);
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

class Line {
  Point s, t;

  Line(Point s, Point t){
    this.s = s; this.t = t;
  }

  /*
   * find a projection for the line st.
  */
  Point projection(Point p){
    Point st = new Point(t.x - s.x, t.y - s.y),
      sp = new Point(p.x - s.x, p.y - s.y);
    double k = Point.dot(st, sp) / st.norm2();
    return Point.add(s, Point.mul(k, st));
  }

  /*
   * find a reflection for the line st.
  */
  Point reflection(Point p){
    return Point.add(Point.sub(
      Point.mul(2.0, 
        Point.sub(projection(p), s)),
          new Point(p.x - s.x, p.y - s.y)), s);
  }
}
