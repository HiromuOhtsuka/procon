import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int ans = (n % 2 == 0 ? n / 2 : n / 2 + 1);

    System.out.println(ans);
  }
}
