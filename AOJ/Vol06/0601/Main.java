import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long[] sum = new long[2 * n + 1];
    for(int i = 1; i <= n; i++){
      sum[i] = sum[i - 1] + a[i - 1];
    }
    for(int i = n + 1; i <= 2 * n; i++){
      sum[i] = sum[i - 1] + a[i - n - 1];
    }

    int s = 0, t = 1;
    long ans = 0;
    while(s <= n){
      long m = sum[t] - sum[s];
      int i = lowerBound(sum, t, 2 * n + 1, sum[t] + m);
      if(s + n > i && m < sum[s + n] - sum[i]){
        ans = Math.max(ans, m);
        ++t;
      }
      else{
        ++s;
      }
    }

    System.out.println(ans);
  }

  private static int lowerBound(long[] a, int low, int high, long x){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid] < x){
        low = mid;
      }
      else{
        high = mid;
      }
    }
    return high;
  }
}
