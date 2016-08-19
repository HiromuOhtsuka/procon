import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m, t;
  static int[] a;
  static List< List< Edge > > G;
  static List< List< Edge > > R;
  static int[] dist1, dist2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); t = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    G = new ArrayList< List< Edge > >(n);
    R = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
      R.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int aa = sc.nextInt() - 1, bb = sc.nextInt() - 1, cc = sc.nextInt();
      G.get(aa).add(new Edge(aa, bb, cc));
      R.get(bb).add(new Edge(bb, aa, cc));
    }

    dist1 = new int[n];
    dijkstra(G, 0, dist1);
    dist2 = new int[n];
    dijkstra(R, 0, dist2);

    long best = -1;
    for(int i = 0; i < n; i++){
      int d = dist1[i] + dist2[i];
      if(d <= t){
        best = Math.max(best, (long)(t - d) * a[i]);
      }
    }

    System.out.println(best);
  }

  private static void dijkstra(List< List< Edge > > graph, int s, int[] dist){
    PriorityQueue< Pair > pq = new PriorityQueue< Pair >();

    for(int v = 0; v < n; v++){
      dist[v] = INF;
    }
    dist[s] = 0;
    pq.offer(new Pair(s, 0));
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      int v = p.v, d = p.d;
      if(d > dist[v]){
        continue;
      }
      dist[v] = d;
      for(int i = 0; i < graph.get(v).size(); i++){
        Edge e = graph.get(v).get(i);
        pq.offer(new Pair(e.w, dist[v] + e.c));
      }
    }
  }

  static class Pair implements Comparable< Pair > {
    int v, d;

    Pair(int v, int d){
      this.v = v; this.d = d;
    }

    @Override
    public int compareTo(Pair p){
      return d - p.d;
    }
  }


  static class Edge {
    int v, w, c;

    Edge(int v, int w, int c){
      this.v = v; this.w = w;
      this.c = c;
    }
  }
}
