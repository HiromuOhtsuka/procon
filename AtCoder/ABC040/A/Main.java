import java.util.Scanner;

public class Main {
  static int n, x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); x = sc.nextInt();

    System.out.println(Math.min(x - 1, n - x));
  }
}
