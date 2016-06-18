import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m, q;
  static List< List< Edge > > G;

  static boolean[] visited;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1, y = sc.nextInt();
      G.get(a).add(new Edge(a, b, y));
      G.get(b).add(new Edge(b, a, y));
    }

    q = sc.nextInt();
    for(int i = 0; i < q; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt();
      visited = new boolean[n];
      int ans = dfs(v, w);
      System.out.println(ans);
    }
  }

  private static int dfs(int v, int y){
    int count = 0;
    visited[v] = true;
    for(int i = 0; i < G.get(v).size(); i++){
      Edge e = G.get(v).get(i);
      if(e.y > y && !visited[e.w]){
        count += dfs(e.w, y);
      }
    }
    return count + 1;
  }

  static class Edge {
    int v, w, y;

    Edge(int v, int w, int y){
      this.v = v; this.w = w;
      this.y = y;
    }
  }
}
