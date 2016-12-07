import java.util.Scanner;

public class Main {
  static long a, b, x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextLong(); b = sc.nextLong();
    x = sc.nextLong();

    long ans = b / x - a / x;
    if(a % x == 0){
      ++ans;
    }

    System.out.println(ans);
  }
}
