import java.util.Scanner;

public class Main{
  static int a, b, c, d;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();

    int sum = 1728 * a + 144 * b + c * 12 + d;

    System.out.println(sum);
  }
}
