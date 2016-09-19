import java.util.Scanner;

public class Main {
  static long l1, r1, l2, r2, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    l1 = sc.nextLong();
    r1 = sc.nextLong();
    l2 = sc.nextLong();
    r2 = sc.nextLong();
    k = sc.nextLong();

    long l = Math.max(l1, l2), r = Math.min(r1, r2);
    long ans = 0;
    if(l <= r){
      if(l <= k && k <= r){
        ans = (r - l + 1) - 1L;
      }
      else{
        ans = (r - l + 1L);
      }
    }

    System.out.println(ans);
  }
}
