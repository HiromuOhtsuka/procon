import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < n; i++){
      int w = sc.nextInt();
      while(w != 0){
        G.get(i).add(new Edge(i, w - 1));
        w = sc.nextInt();
      }
    }

    boolean[][] c = new boolean[n][n];
    for(int v = 0; v < n; v++){
      dfs(v, v, c);
    }

    int k = 1;
    int[] cmp = new int[n];
    for(int v = 0; v < n; v++){
      if(cmp[v] == 0){
        cmp[v] = k;
        for(int w = 0; w < n; w++){
          if(c[v][w] && c[w][v]){
            cmp[w] = k;
          }
        }
        ++k;
      }
    }

    int[] ind = new int[k], outd = new int[k];
    for(int v = 0; v < n; v++){
      for(int j = 0; j < G.get(v).size(); j++){
        int w = G.get(v).get(j).w;
        if(cmp[v] != cmp[w]){
          ind[cmp[w]]++;
          outd[cmp[v]]++;
        }
      }
    }

    int roots = 0, leafs = 0;
    for(int i = 1; i < k; i++){
      if(ind[i] == 0){
        ++roots;
      }
      if(outd[i] == 0){
        ++leafs;
      }
    }

    System.out.println(roots);
    if(k - 1 == 1){
      System.out.println(0);
    }
    else{
      System.out.println(Math.max(roots, leafs));
    }
  }

  private static void dfs(int s, int v, boolean[][] visited){
    visited[s][v] = true;
    for(int i = 0; i < G.get(v).size(); i++){
      int w = G.get(v).get(i).w;
      if(!visited[s][w]){
        dfs(s, w, visited);
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
