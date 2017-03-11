import java.util.Scanner;

public class Main{
  static final double D = 1e-7;
  static final double INF = Integer.MAX_VALUE;
  static int n;
  static int[] x;
  static int[] v;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }
    v = new int[n];
    for(int i = 0; i < n; i++){
      v[i] = sc.nextInt();
    }

    double low = 0, high = INF;
    while((high - low) >= D){
      double mid = (high + low) / 2.0;
      if(f(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    System.out.println(high);
  }

  static boolean f(double t){
    double min = -t * v[0] + x[0];
    double max = t * v[0] + x[0];
    for(int i = 1; i < n; i++){
      double mi = t * -v[i] + x[i];
      double ma = t * v[i] + x[i];
      if(ma < min || mi > max){
        return false;
      }
      if(mi <= min && ma >= max){
        continue;
      }
      if(mi >= min && ma <= max){
        min = mi;
        max = ma;
      }
      else if(max >= ma){
        max = ma;
      }
      else if(min <= mi){
        min = mi;
      }
    }
    return true;
  }
}
