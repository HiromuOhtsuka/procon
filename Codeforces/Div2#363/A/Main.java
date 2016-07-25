import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static boolean[] lr;
  static int[] at;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    String line = sc.next();
    lr = new boolean[n];
    for(int i = 0; i < n; i++){
      if(line.charAt(i) == 'R'){
        lr[i] = true;
      }
    }

    at = new int[n];
    for(int i = 0; i < n; i++){
      at[i] = sc.nextInt();
    }

    int[] l = new int[n], r = new int[n];
    int spl = 0, spr = 0;
    for(int i = 0; i < n; i++){
      if(lr[i]){
        r[spr++] = at[i];
      }
      else{
        l[spl++] = at[i];
      }
    }

    int min = INF;
    Arrays.sort(l, 0, spl); Arrays.sort(r, 0, spr);
    for(int i = 0; i < spl; i++){
      int j = lowerBounds(r, -1, spr, l[i]);
      if(j >= 0 && ((l[i] - r[j]) % 2 == 0)){
        int x = (l[i] - r[j]) / 2;
        min = Math.min(min, x);
      }
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }

  private static int lowerBounds(int[] a, int low, int high, int tar){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid] < tar){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    return low;
  }
}
