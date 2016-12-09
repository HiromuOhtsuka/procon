import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, n1, n2;
  static long[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); n1 = sc.nextInt();  n2 = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    Arrays.sort(a);
    long s = 0, t = 0;
    for(int i = n - 1; i > n - 1 - Math.min(n1, n2); i--){
      s += a[i];
    }
    for(int i = n - 1 - Math.min(n1, n2); i > n - 1 - (n1 + n2); i--){
      t += a[i];
    }

    double ans = (double)s / Math.min(n1, n2) + (double)t / Math.max(n1, n2);

    System.out.println(ans);
  }
}
