import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
  static int n, q;
  static int[] a, b;

  static List< List< Edge > > G;
  static int[] parent;
  static int[] depth;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < n - 1; i++){
      int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
      G.get(x).add(new Edge(x, y)); G.get(y).add(new Edge(y, x));
    }

    q = sc.nextInt();
    a = new int[q]; b = new int[q];
    for(int i = 0; i < q; i++){
      a[i] = sc.nextInt() - 1; b[i] = sc.nextInt() - 1;
    }

    parent = new int[n];
    depth = new int[n];
    parent[0] = -1;
    dfs(0, -1, 0);

    for(int i = 0; i < q; i++){
      int v = a[i], w = b[i];
      if(depth[v] < depth[w]){
        while(depth[w] != depth[v]){
          w = parent[w];
        }
      }
      else{
        while(depth[v] != depth[w]){
          v = parent[v];
        }
      }
      while(v != w){
        v = parent[v];
        w = parent[w];
      }

      int ans = depth[a[i]] + depth[b[i]] - 2 * depth[v] + 1;

      System.out.println(ans);
    }

  }

  private static void dfs(int v, int p, int d){
    depth[v] = d;
    for(int i = 0; i < G.get(v).size(); i++){
      int w = G.get(v).get(i).w;
      if(w != p){
        parent[w] = v;
        dfs(w, v, d + 1);
      }
    }
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}
