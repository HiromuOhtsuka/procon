import java.util.Scanner;

public class Main {
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();

    long a = 1, b = 2;
    while(b * b - a * a < n){
      while(b * b - a * a < n){
        if(n % (b * b - a * a) == 0){
          break;
        }
        ++b;
      }
      if(n % (b * b - a * a) == 0){
        break;
      }
      ++a;
      b = a + 1;
    }

    if(n % (b * b - a * a) == 0){
      long i = n / (b * b - a * a);
      long m = 2 * b * a * i, k = i * (a * a + b * b);
      System.out.println(m + " " + k);
    }
    else{
      System.out.println(-1);
    }
  }

}
