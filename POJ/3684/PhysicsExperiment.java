import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int N;
  static double R, H, T;
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int C = scan.nextInt();
    while(C > 0){
      N = scan.nextInt(); H = scan.nextDouble(); R = scan.nextDouble(); T = scan.nextDouble();

      double[] y = new double[N];
      for(int i = 0; i < N; i++){
        y[i] = getY(T - i);
      }
      Arrays.sort(y);
      for(int i = 0; i < N; i++){
        y[i] += ((double)(2.0 * R * i)) / 100.0;
      }
      for(int i = 0; i < N; i++){
        System.out.printf("%.2f%c", y[i], ((i == N - 1) ? '\n' : ' '));
      }
      --C;
    }
  }

  static double getY(double t){
    if(t < 0.0){
      return H;
    }
    double term = Math.sqrt(2 * H / 10.0);
    int k = (int)(t / term);
    if(k % 2 == 0){
      return H - 0.5 * 10.0 * (t - k * term)*(t - k * term);
    }
    else{
      ++k;
      return H - 0.5 * 10.0 * (t - k * term)*(t - k * term);
    }
  }
}
