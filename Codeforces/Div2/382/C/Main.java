import java.util.Scanner;

public class Main {
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();
    long f1 = 1, f2 = 1;
    int i = 0;
    while(f1 + f2 <= n){
      long f = f1 + f2;
      f1 = f2;  f2 = f;
      ++i;
    }

    System.out.println(i);
  }
}
