import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for(int i=0; i<n; i++){
      double x, y, x1, y1, x2, y2, x3, y3;
      x1 = scan.nextDouble(); y1 = scan.nextDouble();
      x2 = scan.nextDouble(); y2 = scan.nextDouble();
      x3 = scan.nextDouble(); y3 = scan.nextDouble();
      double d12 = (y2-y1) == 0 ? 0 : -(x2-x1)/(y2-y1);
      double d13 = (y3-y1) == 0 ? 0 : -(x3-x1)/(y3-y1);
      double mid12_x = 0.5*(x1+x2), mid12_y = 0.5*(y1+y2);
      double mid13_x = 0.5*(x1+x3), mid13_y = 0.5*(y1+y3);
      if(y2-y1 == 0){
        x = mid12_x;
        y = d13*(x-mid13_x)+mid13_y;
      }
      else if(y3-y1 == 0){
        x = mid13_x;
        y = d12*(x-mid12_x)+mid12_y;
      }
      else{
        x = (mid13_y-mid12_y+d12*mid12_x-d13*mid13_x)/(d12-d13);
        y = d12*(x-mid12_x)+mid12_y;
      }
      double r = Math.sqrt((x1-x)*(x1-x)+(y1-y)*(y1-y));
      System.out.printf("%.3f %.3f %.3f\n", x, y, r);
    }
  }
}
