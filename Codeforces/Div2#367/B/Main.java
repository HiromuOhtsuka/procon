import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, q;
  static int[] x, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
    }
    q = sc.nextInt();
    m = new int[q];
    for(int i = 0; i < q; i++){
      m[i] = sc.nextInt();
    }

    Arrays.sort(x);
    for(int i = 0; i < q; i++){
      int j = upperBound(x, -1, n, m[i]);
      if(0 <= j && j <= n){
        System.out.println(j);
      }
    }
  }

  private static int upperBound(int[] a, int low, int high, int tar){
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
