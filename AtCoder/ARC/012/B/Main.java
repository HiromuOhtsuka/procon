import java.util.Scanner;

public class Main {
  static int n;
  static double va, vb, L;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    va = sc.nextDouble(); vb = sc.nextDouble();
    L = sc.nextDouble();

    double d = L;
    for(int i = 0; i < n; i++){
      d = (d / va) * vb;
    }

    System.out.printf("%.6f\n", d);
  }
}
