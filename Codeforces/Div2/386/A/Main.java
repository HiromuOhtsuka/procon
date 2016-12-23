import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    int min = Math.min(a, Math.min(b / 2, c / 4));
    int ans = min + 2 * min + 4 * min;

    System.out.println(ans);
  }
}
