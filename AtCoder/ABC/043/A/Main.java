import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int ans = n * (n + 1) / 2;

    System.out.println(ans);
  }
}
