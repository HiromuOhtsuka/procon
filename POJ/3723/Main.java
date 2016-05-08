import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public final class Main {
  private int C;
  private static final int DEFAULT_COST = 10000;
  private int N, M, R;
  private List< Edge > edges;
  private UnionFind uf;
  private int best;

  public static final class Edge implements Comparable< Edge > {
    private int from, to, cost;

    Edge(int from, int to, int cost){
      this.from = from;
      this.to = to;
      this.cost = cost;
    }

    int getFrom(){
      return from;
    }

    int getTo(){
      return to;
    }

    int getCost(){
      return cost;
    }

    @Override
      public int compareTo(Edge edge){
        return this.cost - edge.cost;
      }
  }

  public static final class UnionFind {
    private int size;
    private int[] parent;
    private int[] rank;

    UnionFind(int size){
      this.size = size;
      this.parent = new int[size];
      this.rank = new int[size];
      for(int i = 0; i < parent.length; i++){
        this.parent[i] = i;
      }
    }

    void init(){
      for(int i = 0; i < this.parent.length; i++){
        this.parent[i] = i;
        this.rank[i] = 0;
      }
    }

    int findParent(int v){
      if(parent[v] == v){
        return v;
      }
      return parent[v] = findParent(parent[v]);
    }

    void union(int u, int v){
      int up = findParent(u), vp = findParent(v);
      if(up == vp){
        return;
      }
      if(rank[up] < rank[vp]){
        parent[up] = vp;
      }
      else{
        parent[vp] = up;
        if(rank[up] == rank[vp]){
          ++rank[up];
        }
      }
    }

    boolean same(int u, int v){
      return findParent(u) == findParent(v);
    }
  }

  public Main(){
    Scanner scan = new Scanner(System.in);

    C = scan.nextInt();
    uf = new UnionFind(20000);
    for(int i = 0; i < C; i++){
      edges = new ArrayList< Edge >();

      N = scan.nextInt();   M = scan.nextInt();   R = scan.nextInt();

      for(int j = 0; j < R; j++){
        int x, y, d;

        x = scan.nextInt();   y = scan.nextInt();   d = scan.nextInt();

        edges.add(new Edge(x, y + N, -d));
      }
      search();
      System.out.println(DEFAULT_COST * (N + M) + best);
      uf.init();
    }
  }

  private void search(){
    Collections.sort(edges);
    int sum = 0;
    for(int i = 0; i < R; i++){
      Edge e = edges.get(i);
      int from = e.getFrom(), to = e.getTo();
      if(!uf.same(from, to)){
        uf.union(from, to);
        sum += e.getCost();
      }
    }
    best = sum;
  }

  public static void main(String[] args){
    new Main();
  }
}
