import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    long n = scan.nextLong();
    long d = 7 * 8 * 9 * 5;
    long ans = (n / d);

    System.out.println(ans);
  }
}
