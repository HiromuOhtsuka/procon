import java.util.Scanner;

public class Main{
  static int a, b, c, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();

    System.out.println(Math.max(a * b, c * d));
  }
}
