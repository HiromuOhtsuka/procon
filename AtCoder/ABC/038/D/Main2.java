import java.util.Scanner;
import java.util.Arrays;

public class Main2 {
  static int n;
  static Pair[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new Pair[n];
    int maxH = 0;
    for(int i = 0; i < a.length; i++){
      int w = sc.nextInt(), h = sc.nextInt();
      a[i] = new Pair(w, h);
      maxH = Math.max(maxH, h);
    }

    Arrays.sort(a);
    int[] y = new int[n];
    for(int i = 0; i < y.length; i++){
      y[i] = a[i].h;
    }

    LIS lis = new LIS(n, y);
    lis.optimize();

    int ans = lis.getBestValue();

    System.out.println(ans);
  }

  static class Pair implements Comparable< Pair > {
    int w, h;

    Pair(int w, int h){
      this.w = w; this.h = h;
    }

    @Override
    public int compareTo(Pair p){
      if(w == p.w){
        return p.h - h;
      }
      return w - p.w;
    }

  }
}

class LIS {
  int n;
  int[] a;

  int[] l;
  int length;
  int bestValue;

  LIS(int n, int[] a){
    this.n = n;
    this.a = new int[n];
    for(int i = 0; i < this.a.length; i++){
      this.a[i] = a[i];
    }
    this.l = new int[n];
  }

  void optimize(){
    length = 1;
    l[0] = a[0];
    for(int i = 1; i < n; i++){
      if(l[length - 1] < a[i]){
        l[length++] = a[i];
      }
      else{
        int j = lowerBound(a[i], -1, length);
        l[j] = a[i];
      }
    }
    bestValue = length;
  }

  int getBestValue(){
    return bestValue;
  }

  private int lowerBound(int x, int low, int high){
    while(high - low > 1){
      int mid = (high + low) / 2;
      if(l[mid] >= x){
        high = mid;
      }
      else{
        low = mid;
      }
    }
    return high;
  }
}
