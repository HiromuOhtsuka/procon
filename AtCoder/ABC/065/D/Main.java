import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static int[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new int[n];
    y = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    Pair[] xp = new Pair[n];
    Pair[] yp = new Pair[n];
    for(int i = 0; i < n; i++){
      xp[i] = new Pair(x[i], i);
      yp[i] = new Pair(y[i], i);
    }

    Arrays.sort(xp);
    Arrays.sort(yp);

    Edge[] edges = new Edge[n - 1 + n - 1];
    int sp = 0;
    for(int i = 0; i < n - 1; i++){
      edges[i] = new Edge(
        xp[i].index, xp[i + 1].index, xp[i + 1].value - xp[i].value);
    }
    for(int i = 0; i < n - 1; i++){
      edges[i + n - 1] = new Edge(
        yp[i].index, yp[i + 1].index, yp[i + 1].value - yp[i].value);
    }
    Arrays.sort(edges);

    UnionFindTree uf = new UnionFindTree(n);
    long sum = 0;
    for(int i = 0; i < edges.length; i++){
      Edge e = edges[i];
      if(!uf.isSame(e.v, e.w)){
        uf.union(e.v, e.w);
        sum += e.value;
      }
    }

    System.out.println(sum);
  }

  static class Pair implements Comparable< Pair >{
    int value;
    int index;

    Pair(int value, int index){
      this.value = value;
      this.index = index;
    }

    @Override
      public int compareTo(Pair p){
        if(value == p.value){
          return Integer.compare(index, p.index);
        }
        return Integer.compare(value, p.value);
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Pair)){
          return false;
        }
        Pair p = (Pair)obj;
        return value == p.value && index == p.index;
      }
  }

  static class Edge implements Comparable< Edge >{
    int v, w;
    int value;

    Edge(int v, int w, int value){
      this.v = v;
      this.w = w;
      this.value = value;
    }

    @Override
      public int compareTo(Edge e){
        return Integer.compare(value, e.value);
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Edge)){
          return false;
        }
        Edge e = (Edge)obj;
        return (value == e.value) &&
          (v == e.v && w == e.w) ||
          (w == e.v && v == e.w);
      }
  }
}

class UnionFindTree {
  private int N;
  private int[] root, rank;

  public UnionFindTree(int n){
    this.N = n;
    this.root = new int[N];
    this.rank = new int[N];
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
