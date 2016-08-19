import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static int n, m, q;
  static List< Query > queries;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    queries = new ArrayList< Query >();
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1, y = sc.nextInt();
      queries.add(new Query(a, b, y, true));
    }

    q = sc.nextInt();
    for(int i = 0; i < q; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt();
      queries.add(new Query(v, i, w, false));
    }

    Collections.sort(queries);
    UnionFindTree uf = new UnionFindTree(n);
    int[] ans = new int[q];
    for(Query query : queries){
      if(query.isEdge){
        int v = query.v, w = query.w;
        uf.union(v, w);
      }
      else{
        ans[query.w] = uf.childCount(query.v);
      }
    }

    for(int i = 0; i < q; i++){
      System.out.println(ans[i]);
    }
  }

  static class Query implements Comparable< Query > {
    boolean isEdge;
    int v, w, y;

    Query(int v, int w, int y, boolean isEdge){
      this.v = v; this.w = w;
      this.y = y;
      this.isEdge = isEdge;
    }

    @Override
      public int compareTo(Query q){
        if(q.y == y){
          if(q.isEdge && !isEdge){
            return -1;
          }
          else if(!q.isEdge && isEdge){
            return 1;
          }
          else{
            return 0;
          }
        }
        return q.y - y;
      }
  }
}

class UnionFindTree {
  private int N;
  private int[] root, rank, child;

  public UnionFindTree(int n){
    this.N = n;
    this.root = new int[N];
    this.rank = new int[N];
    this.child = new int[N];
    for(int i = 0; i < root.length; i++){
      root[i] = i;
      child[i] = 1;
    }
  }

  public void union(int v, int w){
    int vr = root(v), wr = root(w);
    if(vr == wr){
      return;
    }
    int sum = child[vr] + child[wr];
    child[vr] = child[wr] = sum;
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

  public int childCount(int v){
    return child[root(v)];
  }

  public boolean isSame(int v, int w){
    return root(v) == root(w);
  }
}
