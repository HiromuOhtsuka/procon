import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Arrays;

public class Main {
  static final double INF = Double.MAX_VALUE;
  static int n;
  static double[] x, y, t, r;
  static double[][] G;

  static double[] dist;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new double[n]; y = new double[n];
    t = new double[n]; r = new double[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextDouble();  y[i] = sc.nextDouble();
      t[i] = sc.nextDouble();  r[i] = sc.nextDouble();
    }

    G = new double[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        double d = Math.sqrt(
          (x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
        G[i][j] = d / Math.min(t[i], r[j]);
      }
    }

    dist = new double[n];
    for(int i = 0; i < n; i++){
      dist[i] = INF;
    }

    PriorityQueue< Pair > pq = new PriorityQueue< Pair >();
    pq.offer(new Pair(0, 0));
    dist[0] = 0;
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      for(int w = 0; w < n; w++){
        if(p.d + G[p.v][w] < dist[w]){
          dist[w] = p.d + G[p.v][w];
          pq.offer(new Pair(w, dist[w]));
        }
      }
    }

    Arrays.sort(dist);
    double ans = 0;
    for(int i = n - 1; i >= 1; i--){
      ans = Math.max(ans, dist[i] + (double)(n - i - 1));
    }

    System.out.printf("%.12f\n", ans);
  }

  static class Pair implements Comparable< Pair > {
    int v;
    double d;

    Pair(int v, double d){
      this.v = v; this.d = d;
    }

    @Override
    public int compareTo(Pair p){
      return Double.compare(d, p.d);
    }
  }
}
