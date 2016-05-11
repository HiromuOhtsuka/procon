import java.util.Scanner;

public class Main {
  static int q;
  static Point p0, p1, p2;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    double x0 = sc.nextDouble(), y0 = sc.nextDouble(),
      x1 = sc.nextDouble(), y1 = sc.nextDouble();
    p0 = new Point(x0, y0); p1 = new Point(x1, y1);

    q = sc.nextInt();
    for(int i = 0; i < q; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      p2 = new Point(x, y);
      Point.Position val = Point.ccw(p0, p1, p2);
      switch(val){
        case COUNTER_CLOCKWISE : 
          System.out.println("COUNTER_CLOCKWISE");
          break;
        case CLOCKWISE : 
          System.out.println("CLOCKWISE");
          break;
        case ONLINE_BACK : 
          System.out.println("ONLINE_BACK");
          break;
        case ONLINE_FRONT :
          System.out.println("ONLINE_FRONT");
          break;
        case ON_SEGMENT :
          System.out.println("ON_SEGMENT");
          break;
      }
    }
  }
}

class Point implements Comparable< Point > {
  static final double EPS = 1e-10;
  static enum Position {
    COUNTER_CLOCKWISE, CLOCKWISE, 
    ONLINE_BACK, ONLINE_FRONT,
    ON_SEGMENT
  };
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

  static Position ccw(Point p0, Point p1, Point p2){
    Point a = sub(p1, p0), b = sub(p2, p0);
    if(cross(a, b) > EPS){
      return Position.COUNTER_CLOCKWISE;
    }
    if(cross(a, b) < -EPS){
      return Position.CLOCKWISE;
    }
    if(dot(a, b) < -EPS){
      return Position.ONLINE_BACK;
    }
    if(a.norm2() < b.norm2()){
      return Position.ONLINE_FRONT;
    }
    return Position.ON_SEGMENT;
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
