import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static List< List< Edge > > G;
  static int[] values;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }
    for(int i = 1; i < n; i++){
      int b = sc.nextInt() - 1;
      G.get(i).add(new Edge(i, b));
      G.get(b).add(new Edge(b, i));
    }

    values = new int[n];
    dfs(0, -1);

    System.out.println(values[0]);
  }

  private static void dfs(int v, int p){
    int min = INF, max = -INF;
    for(int i = 0; i < G.get(v).size(); i++){
      Edge e = G.get(v).get(i);
      if(e.w != p){
        dfs(e.w, v);
        min = Math.min(min, values[e.w]);
        max = Math.max(max, values[e.w]);
      }
    }
    values[v] = min + max + 1;
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}
