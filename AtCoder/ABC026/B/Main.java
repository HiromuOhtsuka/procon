import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static double[] r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    r = new double[n];
    for(int i = 0; i < n; i++){
      r[i] = sc.nextDouble();
    }

    Arrays.sort(r);
    double sum = 0;
    boolean flag = true;
    for(int i = n - 1; i > 0; i--){
      if(flag){
        sum += Math.PI * (r[i] * r[i] - r[i - 1] * r[i - 1]);
      }
      flag = !flag;
    }
    if(flag){
      sum += Math.PI * r[0] * r[0];
    }

    System.out.printf("%.6f\n", sum);
  }
}
