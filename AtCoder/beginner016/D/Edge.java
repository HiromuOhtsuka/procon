public class Edge {
  private Point p1, p2;

  public Edge(Point p1, Point p2){
    this.p1 = p1;
    this.p2 = p2;
  }

  public Point getP1(){
    return p1;
  }

  public Point getP2(){
    return p2;
  }

  public boolean isCrossed(Edge e){
    // thisによる直線の式
    int dx1, dy1;
    dx1 = this.p2.getX() - this.p1.getX();
    dy1 = this.p2.getY() - this.p1.getY();
    // eによる直線の式
    int dx2, dy2;
    dx2 = e.getP2().getX() - e.getP1().getX();
    dy2 = e.getP2().getY() - e.getP1().getY();
    int tmp1, tmp2;
    tmp1 = dy1 * (e.getP1().getX() - this.p1.getX()) + dx1 * (this.p1.getY() - e.getP1().getY());
    tmp2 =  dy1 * (e.getP2().getX() - this.p1.getX()) + dx1 * (this.p1.getY() - e.getP2().getY());
    int tmp3, tmp4;
    tmp3 = dy2 * (this.p1.getX() - e.getP1().getX()) + dx2 * (e.getP1().getY() - this.p1.getY());
    tmp4 = dy2 * (this.p2.getX() - e.getP1().getX()) + dx2 * (e.getP1().getY() - this.p2.getY());
    
    if(tmp1 * tmp2 < 0 && tmp3 * tmp4 < 0){
      return true;
    }

    return false;
  }
}
