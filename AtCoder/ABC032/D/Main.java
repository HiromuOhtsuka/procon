import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, W;
  static int[] v, w;

  static boolean[] t;
  static long[][] dp1;
  static long[][] dp2;

  static long best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); W = sc.nextInt();
    v = new int[n]; w = new int[n];
    int c = 1;
    for(int i = 0; i < n; i++){
      v[i] = sc.nextInt();  w[i] = sc.nextInt();
      if(w[i] > 1000){
        c = 3;
      }
      if(v[i] > 1000){
        c = 2;
      }
    }

    if(n <= 30){
      c = 1;
    }

    t = new boolean[n];
    switch(c){
      case 1 : solve1(); break;
      case 2 : solve2(); break;
      case 3 : solve3(); break;
    }

    System.out.println(best);
  }

  private static void solve1(){
    int m = (n / 2);
    Pair[] tmp = new Pair[1 << m];
    int sp = 0;
    for(int s = 0; s < (1 << m); s++){
      long ww = 0, vv = 0;
      for(int j = 0; j < m; j++){
        if((s & (1 << j)) != 0){
          ww += w[j]; vv += v[j];
        }
      }
      tmp[sp++] = new Pair(ww, vv);
    }

    Arrays.sort(tmp);

    Pair[] list = new Pair[1 << m];
    sp = 0;
    long maxv = -1;
    for(Pair p : tmp){
      if(maxv < p.v){
        list[sp++] = p;
        maxv = p.v;
      }
      if(p.w <= W){
        best = Math.max(best, p.v);
      }
    }

    for(int s = 0; s < (1 << (n - m)); s++){
      long ww = 0, vv = 0;
      for(int j = 0; j < (n - m); j++){
        if((s & (1 << j)) != 0){
          ww += w[m + j]; vv += v[m + j];
        }
      }
      if(ww > W){
        continue;
      }

      int j = lowerBound(list, -1, sp, W - ww);
      if(j >= 0 && j < sp){
        vv += list[j].v;
        best = Math.max(best, vv);
      }
      else if(j == sp){
        vv += list[sp - 1].v;
        best = Math.max(best, vv);
      }
    }
  }

  private static int lowerBound(Pair[] a, int low, int high, long key){
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(a[mid].w <= key){
        low = mid;
      }
      else{
        high = mid;
      }
    }
    return low;
  }

  private static void solve2(){
    dp1 = new long[n + 1][200 * 1000 + 1];

    if(w[0] <= W){
      for(int j = w[0]; j <= W; j++){
        dp1[1][j] = v[0];
      }
    }
    for(int i = 2; i <= n; i++){
      for(int j = 1; j <= W; j++){
        if(j - w[i - 1] >= 0){
          dp1[i][j] = Math.max(dp1[i - 1][j], 
              dp1[i - 1][j - w[i - 1]] + v[i - 1]);
        }
        else{
          dp1[i][j] = dp1[i - 1][j];
        }
      }
    }

    best = dp1[n][W];
  }

  private static void solve3(){
    dp2 = new long[n + 1][200 * 1000 + 1];

    for(int i = 0; i <= n; i++){
      for(int j = 0; j < 200 * 1000 + 1; j++){
        dp2[i][j] = INF;
      }
    }

    dp2[1][0] = 0;
    dp2[1][v[0]] = w[0];
    for(int i = 2; i <= n; i++){
      for(int j = 0; j <= 200 * 1000; j++){
        if(j - v[i - 1] >= 0){
          dp2[i][j] = Math.min(dp2[i - 1][j], 
              dp2[i - 1][j - v[i - 1]] + w[i - 1]);
        }
        else{
          dp2[i][j] = dp2[i - 1][j];
        }
      }
    }

    best = 0;
    for(int i = 200 * 1000; i >= 0; i--){
      if(dp2[n][i] != 0 && dp2[n][i] <= W){
        best = i;
        break;
      }
    }
  }

  static class Pair implements Comparable< Pair > {
    long w, v;

    Pair(long w, long v){
      this.w = w; this.v = v;
    }

    @Override
      public int compareTo(Pair p){
        if(w == p.w){
          if(v - p.v > 0L){
            return -1;
          }
          else if(v - p.v < 0L){
            return 1;
          }
          return 0;
        }
        else{
          if(w - p.w > 0L){
            return 1;
          }
          else{
            return -1;
          }
        }
      }

    @Override
      public String toString(){
        return w + " " + v;
      }
  }

}
