import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m, k;
  static int[] a;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1, l = sc.nextInt();
      G.get(u).add(new Edge(u, v, l));  G.get(v).add(new Edge(v, u, l));
    }
    a = new int[k];
    for(int i = 0; i < k; i++){
      a[i] = sc.nextInt() - 1;
    }

    Set< Integer > set = new TreeSet< Integer >();
    for(int i = 0; i < k; i++){
      set.add(a[i]);
    }

    int min = INF;
    for(int i = 0; i < k; i++){
      for(int j = 0; j < G.get(a[i]).size(); j++){
        Edge e = G.get(a[i]).get(j);
        if(!set.contains(e.w)){
          min = Math.min(min, e.d);
        }
      }
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }

  static class Edge {
    int v, w, d;

    Edge(int v, int w, int d){
      this.v = v; this.w = w;
      this.d = d;
    }
  }
}
