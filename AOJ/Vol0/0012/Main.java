import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      double x1, y1, x2, y2, x3, y3, xp, yp;
      x1 = scan.nextDouble(); y1 = scan.nextDouble();
      x2 = scan.nextDouble(); y2 = scan.nextDouble();
      x3 = scan.nextDouble(); y3 = scan.nextDouble();
      xp = scan.nextDouble(); yp = scan.nextDouble();
      double[] para = new double[2];
      // centering (x1, y1)
      x1 = y1 = 0.0;
      x2 -= x1; y2 -= y1; x3 -= x1; y3 -= y1;
      xp -= x1; yp -= y1;
      solve(xp, yp, x2, y2, x3, y3, para);
      if(para[0] >0.0 && para[1] > 0.0 && para[0]+para[1] < 1.0){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
  }

  // center(0, 0)
  // (xp, yp) = ans[0]*(x1, y1) + ans[1]*(x2, y2)
  private static void solve(double xp, double yp, double x1, double y1, double x2, double y2, double[] ans){
    double d = (x1*y2-x2*y1);
    if(d != 0.0){
      ans[0] = (y2*xp - x2*yp)/d;
      ans[1] = (-y1*xp + x1*yp)/d;
    }
    else{
      ans[0]= -1;
      ans[1] = -1;
    }
  }
}
