import java.util.Scanner;

public class Main {
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();

    if(n < 3){
      System.out.println(-1);
      return;
    }

    long m, k;
    if(n % 2 == 0){
      m = (n / 2) * (n / 2) - 1;
      k = m + 2;
    }
    else{
      m = (n * n - 1) / 2;
      k = m + 1;
    }

    System.out.println(m + " " + k);
  }
}
