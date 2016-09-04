import java.util.Scanner;

public class Main {
  static int n;
  static long x;
  static long[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); x = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sum = 0;
    long[] min = new long[n];
    for(int i = 0; i < n; i++){
      min[i] = a[i];
      sum += a[i];
    }
    for(int d = 1; d < n; d++){
      long s = 0;
      for(int i = 0; i < n; i++){
        min[i] = Math.min(min[i], a[(n + i - d) % n]);
        s += min[i];
      }
      sum = Math.min(sum, x * d + s);
    }

    System.out.println(sum);
  }
}
