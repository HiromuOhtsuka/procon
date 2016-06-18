import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static int[] a;

  static long[] dist;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    dist = new long[n];
    for(int i = 1; i < n; i++){
      long d1 = INF, d2 = INF;
      if(i - 1 >= 0){
        d1 = dist[i - 1] + Math.abs(a[i] - a[i - 1]);
      }
      if(i - 2 >= 0){
        d2 = dist[i - 2] + Math.abs(a[i] - a[i - 2]);
      }
      dist[i] = Math.min(d1, d2);
    }

    System.out.println(dist[n - 1]);
  }
}
