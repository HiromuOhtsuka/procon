import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static List< List< Edge > > graph;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    graph = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList< >());
    }
    Map< Edge, Boolean > used = new HashMap< >();
    for(int i = 0; i < m; i++){
      int v = sc.nextInt() - 1;
      int w = sc.nextInt() - 1;
      int c = sc.nextInt();

      Edge e1 = new Edge(v, w, c);
      Edge e2 = new Edge(w, v, c);

      graph.get(v).add(e1);
      graph.get(w).add(e2);

      used.put(e1, false);
    }

    int[] dist = new int[n];
    List< Set< Integer > > prev = new ArrayList< >();
    for(int i = 0; i < n; i++){
      prev.add(new HashSet< >());
    }

    for(int s = 0; s < n; s++){
      for(int t = s + 1; t < n; t++){
        PriorityQueue< Pair > pq = new PriorityQueue< >();

        Arrays.fill(dist, INF);
        for(Set< Integer > set : prev){
          set.clear();
        }

        pq.offer(new Pair(s, 0));
        dist[s] = 0;

        while(!pq.isEmpty()){
          Pair p = pq.poll();
          int v = p.v;
          int d = p.d;
          for(Edge e : graph.get(v)){
            int w = e.w;
            if(dist[w] > d + e.c){
              dist[w] = d + e.c;
              prev.get(w).clear();
              prev.get(w).add(v);
              pq.offer(new Pair(w, dist[w]));
            }
            else if(dist[w] == d + e.c){
              prev.get(w).add(v);
              pq.offer(new Pair(w, dist[w]));
            }
          }
        }

        Queue< Integer > queue = new LinkedList< >();
        queue.offer(t);
        while(!queue.isEmpty()){
          int v = queue.poll();

          if(v == s){
            continue;
          }

          for(int w : prev.get(v)){
            used.put(new Edge(v, w, 0), true);
            queue.offer(w);
          }
        }
      }
    }

    int count = 0;
    for(Map.Entry< Edge, Boolean > e : used.entrySet()){
      if(!e.getValue()){
        ++count;
      }
    }

    System.out.println(count);
  }

  static class Edge{
    int v, w;
    int c;

    Edge(int v, int w, int c){
      this.v = v;
      this.w = w;
      this.c = c;
    }

    @Override
      public int hashCode(){
        int seed = 1234;
        return seed ^ v ^ w;
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Edge)){
          return false;
        }
        Edge e = (Edge)obj;
        return (v == e.v && w == e.w) ||
          (w == e.v && v == e.w);
      }
  }

  static class Pair implements Comparable< Pair >{
    int v;
    int d;

    Pair(int v, int d){
      this.v = v;
      this.d = d;
    }

    @Override
      public int compareTo(Pair p){
        if(d == p.d){
          return Integer.compare(v, p.v);
        }
        return Integer.compare(d, p.d);
      }
  }
}
