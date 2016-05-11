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
