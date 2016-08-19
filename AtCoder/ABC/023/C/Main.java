import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int r, c, k, n;
  static int[] rs, cs;
  static List< List< Integer > > L;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); c = sc.nextInt(); k = sc.nextInt();
    n = sc.nextInt();

    rs = new int[r];  cs = new int[c];
    L = new ArrayList< List< Integer > >(r);
    for(int i = 0; i < r; i++){
      L.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < n; i++){
      int y = sc.nextInt() - 1, x = sc.nextInt() - 1;
      ++rs[y]; ++cs[x];
      L.get(y).add(x);
    }

    int[] csm = new int[c];
    for(int i = 0; i < c; i++){
      csm[i] = cs[i];
    }

    Arrays.sort(cs);

    long count = 0;
    for(int i = 0; i < r; i++){
      if(Arrays.binarySearch(cs, 0, c, k - rs[i]) >= 0){
        int tmp1 = upperBound(cs, -1, c, k - rs[i]) - lowerBound(cs, -1, c, k - rs[i]);
        int s1 = 0;
        for(Integer x : L.get(i)){
          if(csm[x] == k - rs[i]){
            ++s1;
          }
        }
        count += (tmp1 - s1);
      }
      for(Integer x : L.get(i)){
        if(csm[x] == k - rs[i] + 1){
          ++count;
        }
      }
    }

    System.out.println(count);
  }

  private static int lowerBound(int[] a, int low, int high, int tar){
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

  private static int upperBound(int[] a, int low, int high, int tar){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid] <= tar){
        low = mid;
      }
      else{
        high = mid;
      }
    }
    return high;
  }
}
