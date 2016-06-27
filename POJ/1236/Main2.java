import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n;
  static List< List< Edge > > G;
  static List< List< Edge > > R;
  // for Kosaraj algorithm 
  static int order, k;
  static int[] ph, rPh;
  static boolean[] visited;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    G = new ArrayList< List< Edge > >(n);
    R = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
      R.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < n; i++){
      int w = sc.nextInt();
      while(w != 0){
        G.get(i).add(new Edge(i, w - 1));
        R.get(w - 1).add(new Edge(w - 1, i));
        w = sc.nextInt();
      }
    }

    // Kosaraj algorithm
    int[] cmp = new int[n];
    decompose(cmp);

    ++k;
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

  // Kosaraj algorithm
  static void decompose(int[] cmp){
    ph = new int[n];
    rPh = new int[n + 1];
    visited = new boolean[n];
    order = 0;

    for(int v = 0; v < n; v++){
      if(!visited[v]){
        visit1(v);
      }
    }

    for(int i = 0; i < n; i++){
      visited[i] = false;
    }

    k = 0;
    for(int i = n; i >= 1; i--){
      if(!visited[rPh[i]]){
        ++k;
        visit2(rPh[i], cmp);
      }
    }
  }

  static void visit1(int v){
    visited[v] = true;

    for(int i = 0; i < G.get(v).size(); i++){
      int w = G.get(v).get(i).w;
      if(!visited[w]){
        visit1(w);
      }
    }

    ph[v] = ++order;
    rPh[order] = v;
  }

  static void visit2(int v, int[] cmp){
    visited[v] = true;

    for(int i = 0; i < R.get(v).size(); i++){
      int w = R.get(v).get(i).w;
      if(!visited[w]){
        visit2(w, cmp);
      }
    }

    cmp[v] = k;
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}

