import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static int[] h, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    h = new int[n]; s = new int[n];

    for(int i = 0; i < n; i++){
      h[i] = sc.nextInt();  s[i] = sc.nextInt();
    }

    long low = -1, high = 1000000000000000L;
    while(high - low > 1){
      long mid = (high + low) / 2;
      if(f(mid)){
        high = mid;
      }
      else{
        low = mid;
      }
    }

    System.out.println(high);
  }

  private static boolean f(long k){
    Pair[] y = new Pair[n];
    for(int i = 0; i < n; i++){
      y[i] = new Pair((double)((double)(k - h[i]) / s[i]), i);
    }
    Arrays.sort(y);
    long max = 0;
    for(int i = 0; i < n; i++){
      max = Math.max(max, (long)i * s[y[i].t] + h[y[i].t]);
    }
    return max <= k;
  }

  static class Pair implements Comparable< Pair > {
    double s;
    int t;

    Pair(double s, int t){
      this.s = s; this.t = t;
    }

    @Override
    public int compareTo(Pair p){
      return new Double(s).compareTo(p.s);
    }
  }
}
