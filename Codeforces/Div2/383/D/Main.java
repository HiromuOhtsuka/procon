import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n, m, W;
  static int[] w, b;
  static List< List< Integer > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); W = sc.nextInt();
    w = new int[n]; b = new int[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }
    G = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Integer >());
    }
    for(int i = 0; i < m; i++){
      int s = sc.nextInt() - 1, t = sc.nextInt() - 1;
      G.get(s).add(t);  G.get(t).add(s);
    }

    int count = 0;
    int[] connect = new int[n];
    boolean[] visited = new boolean[n];
    for(int v = 0; v < n; v++){
      if(!visited[v]){
        dfs(v, visited, connect, ++count);
      }
    }

    List< Set< Integer > > components = new ArrayList< Set< Integer > >(count);
    for(int i = 0; i < count; i++){
      components.add(new TreeSet< Integer >());
    }
    for(int v = 0; v < n; v++){
      components.get(connect[v] - 1).add(v);
    }

    int[] ws = new int[count], bs = new int[count];
    for(int v = 0; v < n; v++){
      ws[connect[v] - 1] += w[v];
      bs[connect[v] - 1] += b[v];
    }

    int[][] dp = new int[count + 1][W + 1];
    for(int i = 1; i <= count; i++){
      for(int j = 0; j <= W; j++){
        if(j - ws[i - 1] >= 0){
          dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - ws[i - 1]] + bs[i - 1]);
        }
        for(int v : components.get(i - 1)){
          if(j - w[v] >= 0){
            dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - w[v]] + b[v]);
          }
        }
        dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
      }
    }

    System.out.println(dp[count][W]);
  }

  private static void dfs(int v, boolean[] visited, int[] connect, int c){
    visited[v] = true;  connect[v] = c;
    for(Integer w : G.get(v)){
      if(!visited[w]){
        dfs(w, visited, connect, c);
      }
    }
  }
}
