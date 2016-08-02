import java.util.Scanner;

public class Main {
  static int s, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.nextInt(); t = sc.nextInt();

    int ans = t - s + 1;

    System.out.println(ans);
  }
}
