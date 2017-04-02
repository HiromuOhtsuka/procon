import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long[] d = new long[n - 1];
    for(int i = 0; i + 1 < n; i++){
      d[i] = Math.abs(a[i] - a[i + 1]);
    }

    int m = n - 1;
    long[][] max = new long[m + 1][2];
    max[0][0] = max[0][1] = -INF;
    for(int i = 1; i <= m; i++){
      max[i][0] = max[i - 1][1] - d[i - 1];
      max[i][1] = Math.max(d[i - 1], max[i - 1][0] + d[i - 1]);
    }

    long ans = 0;
    for(int i = 1; i <= m; i++){
      ans = Math.max(ans, Math.max(max[i][0], max[i][1]));
    }

    System.out.println(ans);
  }
}
