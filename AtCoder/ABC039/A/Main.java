import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    c = sc.nextInt();

    int ans = a * b * 2 + a * c * 2 + b * c * 2;

    System.out.println(ans);
  }
}
