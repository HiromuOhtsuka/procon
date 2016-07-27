import java.util.Scanner;

public class Main {
  static int a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();

    int ans = Math.min(Math.abs(a - b), 10 - Math.abs(a - b));

    System.out.println(ans);
  }
}
