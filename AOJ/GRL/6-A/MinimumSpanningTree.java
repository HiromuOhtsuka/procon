import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Edge implements Comparable< Edge > {
  int from, to, cost;

  public Edge(int from, int to, int cost){
    this.from = from; this.to = to;
    this.cost = cost;
  }

  @Override
    public int compareTo(Edge e){
      return this.cost - e.cost;
    }
}

class UnionFindTree {
  private int N;
  private int[] root, rank;

  public UnionFindTree(int n){
    this.N = n;
    root = new int[N];
    rank = new int[N];
    for(int i = 0; i < root.length; i++){
      root[i] = i;
    }
  }

  public void union(int v, int w){
    int vr = root(v), wr = root(w);
    if(vr == wr){
      return;
    }
    if(rank[vr] < rank[wr]){
      root[vr] = wr;
    }
    else{
      root[wr] = vr;
      if(rank[vr] == rank[wr]){
        ++rank[vr];
      }
    }
  }

  public int root(int v){
    if(root[v] == v){
      return v;
    }
    return root[v] = root(root[v]);
  }

  public boolean isSame(int v, int w){
    return root(v) == root(w);
  }
}

class MinimumSpanningTree {
  public static final int INF 
    = Integer.MAX_VALUE;
  private int N, M;
  private List< Edge > E;

  private int value;
  private List< Edge > solution;

  public MinimumSpanningTree(int n, int m, 
      List< Edge > e){
    this.N = n; this.M = m;
    this.E = e;
  }

  public void optimize(){
    solution = new ArrayList< Edge >(N - 1);
    UnionFindTree uft = new UnionFindTree(N);
    Collections.sort(E);
    int sum = 0;
    for(Edge e : E){
      if(!uft.isSame(e.from, e.to)){
        uft.union(e.from, e.to);
        sum += e.cost;
        solution.add(e);
      }
    }
    value = sum;
  }

  public int getValue(){
    return value;
  }

  public List< Edge > getSolution(){
    return solution;
  }

}
