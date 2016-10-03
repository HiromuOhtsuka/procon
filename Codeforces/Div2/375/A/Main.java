import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int x1, x2, x3;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x1 = sc.nextInt();  x2 = sc.nextInt();  x3 = sc.nextInt();
    int min = INF;
    for(int x = 1; x <= 100; x++){
      int total = Math.abs(x - x1) + Math.abs(x - x2) + Math.abs(x - x3);
      min = Math.min(min, total);
    }

    System.out.println(min);
  }
}
