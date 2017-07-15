import java.util.Scanner;

public class Main{
  static long n, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt();
    b = sc.nextInt();

    if(a > b || (a != b && n == 1)){
      System.out.println(0);
      return;
    }

    System.out.println(b * (n - 2) - a * (n - 2) + 1);
  }
}
