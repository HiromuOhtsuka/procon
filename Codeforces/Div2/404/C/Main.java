import java.util.Scanner;

public class Main{
  static long n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();
    m = sc.nextLong();

    if(m >= n){
      System.out.println(n);
      return;
    }

    long low = 0, high = Integer.MAX_VALUE;
    while(high - low > 1){
      long mid = (low + high) / 2L;
      if(mid * (mid + 1L) >= 2 * (n - m)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    long ans = m + high;

    System.out.println(ans);
  }
}
