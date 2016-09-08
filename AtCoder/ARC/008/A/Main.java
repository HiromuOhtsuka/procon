import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int ans = (n / 10) * 100 + ((n % 10 != 0 ? (n % 10) * 15 : 0));

    ans = Math.min(ans, (n / 10 + 1) * 100);

    System.out.println(ans);
  }
}
