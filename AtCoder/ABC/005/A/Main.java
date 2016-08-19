import java.util.Scanner;

public class Main {
  static int x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt(); y = sc.nextInt();

    int ans = y / x;

    System.out.println(ans);
  }
}
