import java.util.Scanner;

public class Main {
  static int n, b, p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); b = sc.nextInt(); p = sc.nextInt();

    int x = 0, m = n;
    while(m != 1){
      int k;
      for(k = 9; (1 << k) > m; k--);
      x += 2 * k * b + k;
      m -= k;
    }
    int y = n * p;

    System.out.println(x + " " + y);
  }
}
