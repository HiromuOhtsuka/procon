import java.util.Scanner;

public class Main {
  static int a, b, h;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    h = sc.nextInt();

    int ans = (a + b) * h / 2;

    System.out.println(ans);
  }
}
