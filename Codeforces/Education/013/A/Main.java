import java.util.Scanner;

public class Main {
  static int n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();

    int ans = n + (k - (n % k));

    System.out.println(ans);
  }
}
