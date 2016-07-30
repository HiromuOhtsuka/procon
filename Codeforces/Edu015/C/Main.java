import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, m;
  static long[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    b = new long[m];
    for(int i = 0; i < m; i++){
      b[i] = sc.nextInt();
    }

    long max = 0;
    for(int i = 0; i < n; i++){
      int lb = lowerBound(b, -1, m, a[i]);
      int ub = upperBound(b, -1, m, a[i]);
      long d = INF;
      if(lb < m){
        d = Math.min(d, Math.abs(b[lb] - a[i]));
      }
      if(lb - 1 >= 0){
        d = Math.min(d, Math.abs(b[lb - 1] - a[i]));
      }
      if(ub - 1 >= 0){
        d = Math.min(d, Math.abs(a[i] - b[ub - 1]));
      }
      if(ub < m){
        d = Math.min(d, Math.abs(a[i] - b[ub]));
      }
      max = Math.max(max, d);
    }

    System.out.println(max);
  }

  private static int lowerBound(long[] a, int low, int high, long tar){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid] < tar){
        low = mid;
      }
      else{
        high = mid;
      }
    }
    return high;
  }

  private static int upperBound(long[] a, int low, int high, long tar){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid] > tar){
        high = mid;
      }
      else{
        low = mid;
      }
    }
    return high;
  }
}
