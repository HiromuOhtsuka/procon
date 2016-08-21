import java.util.Scanner;

public class Main {
  static int x1, y1, x2, y2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x1 = sc.nextInt();  y1 = sc.nextInt();
    x2 = sc.nextInt();  y2 = sc.nextInt();

    int max = 0;
    max = Math.max(max, Math.abs(x1 - x2));
    max = Math.max(max, Math.abs(y1 - y2));

    System.out.println(max);
  }
}
