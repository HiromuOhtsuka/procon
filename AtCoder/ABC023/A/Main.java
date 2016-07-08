import java.util.Scanner;

public class Main {
  static int x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt();
    int ans = x % 10 + (x / 10) % 10;

    System.out.println(ans);
  }
}
