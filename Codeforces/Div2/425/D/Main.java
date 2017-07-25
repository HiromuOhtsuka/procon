import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;

public class Main{
  static int n, q;
  static int[] p;
  static int[] a, b, c;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    q = sc.nextInt();
    p = new int[n];
    for(int i = 1; i < n; i++){
      p[i] = sc.nextInt() - 1;
    }
    a = new int[q];
    b = new int[q];
    c = new int[q];
    for(int i = 0; i < q; i++){
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
      c[i] = sc.nextInt() - 1;
    }

    int[][] edges = new int[n][2];
    for(int i = 1; i < n; i++){
      edges[i][0] = i;
      edges[i][1] = p[i];
    }

    StringBuilder sb = new StringBuilder();
    LCA lca = new LCA(n, edges);
    lca.optimize();
    for(int i = 0; i < q; i++){
      if(DEBUG){
        System.out.println("- " + i);
      }
      int max = intersection(a[i], b[i], c[i], lca);
      max = Math.max(max, intersection(a[i], c[i], b[i], lca));
      max = Math.max(max, intersection(b[i], a[i], c[i], lca));
      max = Math.max(max, intersection(b[i], c[i], a[i], lca));
      max = Math.max(max, intersection(c[i], a[i], b[i], lca));
      max = Math.max(max, intersection(c[i], b[i], a[i], lca));

      sb.append(max + System.lineSeparator());
    }

    System.out.print(sb);
  }

  static int intersection(int s, int t, int f, LCA lca){
    int ans = 0;
    if(f == s || f == t){
      return 1;
    }
    if(lca.lca(f, s) == f){
      ans = Math.max(ans, lca.rank(lca.lca(s, t)) - lca.rank(f));
    }
    else if(lca.lca(f, s) != lca.lca(f, t)){
      ans = Math.max(ans, lca.rank(f) - 
        Math.max(lca.rank(lca.lca(f, s)), lca.rank(lca.lca(f, t))));
    }
    else{
      ans = Math.max(ans, lca.rank(f) + 
        lca.rank(lca.lca(s, t)) - 2 * lca.rank(lca.lca(f, t)));
    }
    return ans + 1;
  }
}

class LCA {
  int n;
  List< List< Integer > > T;

  int[] depth;
  int[][] parent;

  LCA(int n, List< List< Integer > > T){
    this.n = n;
    this.T = T;
  }

  LCA(int n, int[][] edges){
    this.n = n;
    T = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      T.add(new ArrayList< Integer >());
    }
    for(int[] p : edges){
      T.get(p[0]).add(p[1]); T.get(p[1]).add(p[0]);
    }
  }

  void optimize(){
    depth = new int[n];
    int[] par = new int[n];
    dfs(0, -1, 0, par);

    parent = new int[n][21];
    for(int v = 0; v < n; v++){
      parent[v][0] = par[v];
    }
    for(int i = 1; i < 21; i++){
      for(int j = 0; j < n; j++){
        if(parent[j][i - 1] != -1){
          parent[j][i] = parent[parent[j][i - 1]][i - 1];
        }
      }
    }
  }

  int lca(int u, int v){
    if(u == 0 || v == 0){
      return 0;
    }
    if(depth[u] > depth[v]){
      int tmp = u;  u = v;  v = tmp;
    }

    for(int i = 20; i >= 0; i--){
      if((((depth[v] - depth[u]) >> i) & 1) != 0){
        v = parent[v][i];
      }
    }

    if(u == v){
      return u;
    }

    for(int i = 20; i >= 0; i--){
      if(parent[u][i] != parent[v][i]){
        u = parent[u][i]; v = parent[v][i];
      }
    }

    return parent[u][0];
  }

  int rank(int v){
    return depth[v];
  }

  void dfs(int v, int p, int d, int[] par){
    Stack< Edge > stack = new Stack< Edge >();
    stack.push(new Edge(v, p, d));
    while(!stack.isEmpty()){
      Edge e = stack.pop();
      depth[e.v] = e.d;
      par[e.v] = e.p;
      for(Integer w : T.get(e.v)){
        if(w != e.p){
          stack.push(new Edge(w, e.v, e.d + 1));
        }
      }
    }
  }

  class Edge {
    int v, p, d;

    Edge(int v, int p, int d){
      this.v = v; this.p = p; this.d = d;
    }
  }
}
