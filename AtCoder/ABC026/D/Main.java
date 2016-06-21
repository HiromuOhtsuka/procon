import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    c = sc.nextInt();

    double low = 0, high = 200;
    for(;;){
      double mid = (low + high) / 2;
      double val = f(mid);
      if(Math.abs(val - 100.0) <= 1e-6){
        break;
      }
      if(val > 100.0){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    System.out.println((low + high) / 2);
  }

  private static double f(double x){
    return a * x + b * Math.sin(c * x * Math.PI);
  }
}
