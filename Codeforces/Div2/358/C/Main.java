import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n;
  static int[] a;
  static List< List< Edge > > G;

  static long[] dist;
  static int[] child;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >(2));
    }

    for(int i = 1; i < n; i++){
      int t = sc.nextInt() - 1, c = sc.nextInt();
      G.get(i).add(new Edge(i, t, c));
      G.get(t).add(new Edge(t, i, c));
    }

    dist = new long[n];
    child = new int[n];
    dfs(0, -1, 0);

    int[] parents = new int[n];
    int ans = dfs2(0, -1, parents, 0);

    System.out.println(ans);
  }

  private static int dfs(int v, int p, long d){
    int count = 0;
    dist[v] = d;
    for(int i = 0; i < G.get(v).size(); i++){
      Edge e = G.get(v).get(i);
      int w = e.t, c = e.c;
      if(w != p){
        count += dfs(w, v, d + c);
      }
    }
    child[v] = count;
    return count + 1;
  }

  private static int dfs2(int v, int p, int[] parents, int sp){
    for(int i = 0; i < sp; i++){
      if((dist[v] - dist[parents[i]]) > a[v]){
        return child[v] + 1;
      }
    }
    parents[sp] = v;
    int count = 0;
    for(int i = 0; i < G.get(v).size(); i++){
      Edge e = G.get(v).get(i);
      int w = e.t, c = e.c;
      if(w != p){
        count += dfs2(w, v, parents, sp + 1);
      }
    }
    return count;
  }

  static class Edge {
    int s, t, c;

    Edge(int s, int t, int c){
      this.s = s; this.t = t;
      this.c = c;
    }
  }
}
