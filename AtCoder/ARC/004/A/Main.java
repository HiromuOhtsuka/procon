import java.util.Scanner;

public class Main {
  static int n;
  static double[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new double[n];  y = new double[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextDouble(); y[i] = sc.nextDouble();
    }

    double max = 0;
    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        double dist = Math.sqrt(
          (x[j] - x[i]) * (x[j] - x[i]) + (y[j] - y[i]) * (y[j] - y[i]));
        max = Math.max(max, dist);
      }
    }

    System.out.println(max);
  }
}
