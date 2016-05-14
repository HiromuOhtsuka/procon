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
