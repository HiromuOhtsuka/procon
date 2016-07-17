import java.util.Scanner;

public class Main {
  static int n;
  static double[][] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new double[n][2]; b = new double[n][2];
    for(int i = 0; i < n; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      a[i][0] = x;  a[i][1] = y;
    }
    for(int i = 0; i < n; i++){
      double x = sc.nextDouble(), y = sc.nextDouble();
      b[i][0] = x;  b[i][1] = y;
    }

    double a0 = 0, a1 = 0;
    for(int i = 0; i < n; i++){
      a0 += a[i][0];
      a1 += a[i][1];
    }
    double[] ap = new double[2];
    ap[0] = a0 / (double)n; ap[1] = a1 / (double)n;
    double da = 0;
    for(int i = 0; i < n; i++){
      da = Math.max(da, dist(ap, a[i]));
    }

    double b0 = 0, b1 = 0;
    for(int i = 0; i < n; i++){
      b0 += b[i][0];
      b1 += b[i][1];
    }
    double[] bp = new double[2];
    bp[0] = b0 / (double)n; bp[1] = b1 / (double)n;
    double db = 0;
    for(int i = 0; i < n; i++){
      db = Math.max(db, dist(bp, b[i]));
    }

    double p = db / da;

    System.out.println(p);
  }

  private static double dist(double[] p1, double[] p2){
    return Math.sqrt((p2[0] - p1[0]) * (p2[0] - p1[0]) +
      (p2[1] - p1[1]) * (p2[1] - p1[1]));
  }
}
