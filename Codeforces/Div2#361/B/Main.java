import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static List< List< Edge > > G;
  static int[] dist;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < n; i++){
      int a = sc.nextInt() - 1;
      G.get(i).add(new Edge(i, a));
    }

    for(int i = 0; i < n - 1; i++){
      G.get(i).add(new Edge(i, i + 1));
      G.get(i + 1).add(new Edge(i + 1, i));
    }

    dist = new int[n];
    for(int i = 0; i < n; i++){
      dist[i] = INF;
    }

    PriorityQueue< Pair > pq = new PriorityQueue< Pair >();
    pq.offer(new Pair(0, 0));
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      if(p.d < dist[p.v]){
        dist[p.v] = p.d;
      }
      else{
        continue;
      }
      for(int i = 0; i < G.get(p.v).size(); i++){
        int w = G.get(p.v).get(i).w;
        pq.offer(new Pair(w, p.d + 1));
      }
    }

    for(int i = 0; i < n; i++){
      System.out.print(dist[i]);
      System.out.print((i == n - 1) ? "\n" : " ");
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
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}
