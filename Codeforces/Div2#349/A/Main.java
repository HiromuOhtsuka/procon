import java.util.Scanner;

public class Main {
  static double d, h, v, e;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    d = sc.nextDouble();  h = sc.nextDouble();
    v = sc.nextDouble();  e = sc.nextDouble();

    double s = (d / 2.0) * (d / 2.0) * Math.PI;

    if((e * s - v) >= 0){
      System.out.println("NO");
      return;
    }

    double time = (- s * h) / (e * s - v);

    System.out.println("YES");
    System.out.println(time);
  }
}
