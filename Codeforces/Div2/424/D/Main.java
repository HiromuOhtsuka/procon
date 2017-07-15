import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final long INF = Long.MAX_VALUE / 2;
  static int n, k, p;
  static long[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    p = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    b = new long[k];
    for(int i = 0; i < k; i++){
      b[i] = sc.nextInt();
    }

    Arrays.sort(a);
    Arrays.sort(b);

    long low = -1, high = INF;
    while(high - low > 1){
      long mid = (low + high) / 2;
      if(f(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    System.out.println(high);
  }

  static boolean f(long t){
    for(int i = 0; i < n; i++){
      boolean found = false;
      for(int j = 0; j < k; j++){
        if(Math.abs(a[i] - b[j]) + Math.abs(b[j] - p) <= t){
          found = true;
          break;
        }
      }
      if(!found){
        return false;
      }
    }

    boolean[] exist = new boolean[k];
    Arrays.fill(exist, true);
    for(int i = 0; i < n; i++){
      boolean yes = false;
      for(int j = 0; j < k; j++){
        if(Math.abs(a[i] - b[j]) + Math.abs(b[j] - p) <= t && exist[j]){
          yes = true;
          exist[j] = false;
          break;
        }
      }
      if(!yes){
        return false;
      }
    }

    return true;
  }
}
