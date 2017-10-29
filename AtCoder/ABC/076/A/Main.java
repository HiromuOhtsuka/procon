import java.util.Scanner;

public class Main{
  static int r, g;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt();
    g = sc.nextInt();

    System.out.println(2 * g - r);
  }
}
