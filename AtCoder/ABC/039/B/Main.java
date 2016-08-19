import java.util.Scanner;

public class Main {
  static int x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt();

    int ans = (int)Math.sqrt(Math.sqrt(x));

    System.out.println(ans);
  }
}
