import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Stack;

public class Main {
  static int n, q;
  static List< List< Integer > > T;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    T = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      T.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < n - 1; i++){
      int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
      T.get(x).add(y);  T.get(y).add(x);
    }
    q = sc.nextInt();
    a = new int[q]; b = new int[q];
    for(int i = 0; i < q; i++){
      a[i] = sc.nextInt() - 1; b[i] = sc.nextInt() - 1;
    }

    LCA lca = new LCA(n, T);
    lca.optimize();

    int[] ans = new int[q];
    for(int i = 0; i < q; i++){
      int ancester = lca.lca(a[i], b[i]);
      ans[i] = lca.rank(a[i]) - lca.rank(ancester) +
        lca.rank(b[i]) - lca.rank(ancester) + 1;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++){
      sb.append(ans[i] + System.lineSeparator());
    }

    System.out.print(sb);
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
