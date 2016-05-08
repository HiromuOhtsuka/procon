import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public final class Main {
  private int N;
  private List< Edge > G;
  private UnionFind uf;
  private int best;

  private static class Edge implements Comparable< Edge >{
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
      public int compareTo(Edge e){
        return this.cost - e.cost;
      }
  }

  private static class UnionFind {
    public static final int NO_PARENT = -1;
    private int[] parent, depth;
    private int size;

    UnionFind(int size){
      this.size = size;
      this.parent = new int[size];
      this.depth = new int[size];
      for(int i = 0; i < this.parent.length; i++){
        this.parent[i] = i;
      }
    }

    int findParent(int v){
      if(v <= -1 || v >= size){
        return NO_PARENT;
      }
      if(parent[v] == v){
        return v;
      }
      return parent[v] = findParent(parent[v]);
    }

    boolean isSame(int u, int v){
      return findParent(u) == findParent(v);
    }

    void union(int u, int v){
      int up = findParent(u), vp = findParent(v);
      if(up == vp){
        return;
      }
      if(depth[up] < depth[vp]){
        parent[up] = vp;
      }
      else{
        parent[vp] = up;
        if(depth[up] == depth[vp]){
          ++depth[up];
        }
      }
    }
  }

  public Main(){
    Scanner scan = new Scanner(System.in);

    while(scan.hasNextInt()){
      N = scan.nextInt();
      G = new ArrayList< Edge >();
      for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
          int cost = scan.nextInt();
          if(i == j){
            continue;
          }
          G.add(new Edge(i, j, cost));
          G.add(new Edge(j, i, cost));
        }
      }
      uf = new UnionFind(N);
      search();
      System.out.println(best);
    }
  }

  private void search(){
    Collections.sort(G);
    int sum = 0;
    for(int i = 0; i < G.size(); i++){
      Edge e = G.get(i);
      if(!uf.isSame(e.getFrom(), e.getTo())){
        sum += e.getCost();
        uf.union(e.getFrom(), e.getTo());
      }
    }
    best = sum;
  }

  public static void main(String[] args){
    new Main();
  }
}
