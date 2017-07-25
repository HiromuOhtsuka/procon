import java.util.Scanner;

public class Main{
  static long n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();
    k = sc.nextLong();

    if((n / k) % 2 == 0){
      System.out.println("NO");
    }
    else{
      System.out.println("YES");
    }
  }
}
