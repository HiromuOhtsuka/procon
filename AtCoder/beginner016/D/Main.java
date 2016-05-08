import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int x1, y1, x2, y2;
    x1 = scan.nextInt();
    y1 = scan.nextInt();
    x2 = scan.nextInt();
    y2 = scan.nextInt();
    Edge e = new Edge(new Point(x1, y1), new Point(x2, y2));
    int n = scan.nextInt();
    Point[] point = new Point[n];
    for(int i=0; i<n; ++i){
      int x, y;
      x = scan.nextInt();
      y = scan.nextInt();
      point[i] = new Point(x, y);
    }
    Edge[] edge = new Edge[n];
    for(int i=0; i<n; ++i){
      edge[i] = new Edge(point[i], point[(i + 1) % n]);
    }
    int count = 0;
    for(int i=0; i<edge.length; ++i){
      if(edge[i].isCrossed(e)){
        ++count;
      }
    }
    System.out.println(count / 2 + 1);
  }
}
