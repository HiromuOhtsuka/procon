import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int N, K;
  static double[] W, P;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt(); K = scan.nextInt();
    W = new double[N];  P = new double[N];
    for(int i = 0; i < N; i++){
      W[i] = scan.nextDouble(); P[i] = scan.nextDouble();
    }

    final double ESP = 1e-7;
    double low = 0.0, high = 1e13;
    while(high - low >= ESP){
      double mid = (low + high) / 2.0;
      if(f(mid)){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.printf("%.6f\n", low);
  }

  static boolean f(double x){
    double[] y = new double[N];
    for(int i = 0; i < N; i++){
      y[i] = W[i] * P[i] - x * W[i];
    }
    Arrays.sort(y);
    double sum = 0;
    for(int i = 0; i < K; i++){
      sum += y[N - i - 1];
    }
    return sum >= 0.0;
  }
}
