import java.util.Scanner;

public class Main {
  static long n, d, x, y;
  static int count;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); d = sc.nextInt();
    x = sc.nextInt(); y = sc.nextInt();

    if(x % d != 0 || y % d != 0){
      System.out.println(0.0);
      return;
    }

    long count = 0;
    for(long p = 0; p <= n; p++){
      long q = n - p;
      long z = x / d;
      long tmp1 = 1, tmp2 = 1;
      if(p - z >= 0){
        for(long i = p; i > p - z; i--){
          tmp1 *= i;
        }
        if(tmp1 < 0){
          System.out.println("of1");
        }
        for(long i = z; i >= 1; i--){
          tmp1 /= i;
        }
        if(tmp1 < 0){
          System.out.println("of2");
        }
      }
      else{
        tmp1 = 0;
      }
      z = y / d;
      if(q - z >= 0){
        for(long i = q; i > q - z; i--){
          tmp2 *= i;
        }
        if(tmp2 < 0){
          System.out.println("of3");
        }
        for(long i = z; i >= 1; i--){
          tmp2 /= i;
        }
        if(tmp2 < 0){
          System.out.println("of4");
        }
      }
      else{
        tmp2 = 0;
      }

      if(tmp1 == 0 || tmp2 == 0){
        continue;
      }

      long tmp = 1;
      for(long i = (tmp1 + tmp2); i > Math.max(tmp1, tmp2); i--){
        tmp *= i;
      }
      if(tmp < 0){
        System.out.println("of5");
      }
      for(long i = Math.min(tmp1, tmp2); i >= 1; i--){
        tmp /= i;
      }
      if(tmp < 0){
        System.out.println("of6");
      }

      count += tmp;
    }

    System.out.println(count);
    System.out.println((1L << (2L * n)));

    double ans = (double)count / (double)(1L << (2L * n));

    System.out.println(ans);
  }
}
