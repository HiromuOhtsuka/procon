import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Sub1 {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, g, e;
  static int[] p;
  static int[][] edges;
  static boolean[][] G;
  static List< List< Edge > > T;
  static boolean[] visited;

  static int best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); g = sc.nextInt(); e = sc.nextInt();
    p = new int[g];
    for(int i = 0; i < g; i++){
      p[i] = sc.nextInt();
    }
    edges = new int[e][2];
    G = new boolean[n][n];
    for(int i = 0; i < e; i++){
      int a = sc.nextInt(), b = sc.nextInt();
      edges[i][0] = a;  edges[i][1] = b;
      G[a][b] = G[b][a] = true;
    }

    best = INF;
    visited = new boolean[n];
    backTrack(0, 0);

    System.out.println(best);
  }

  private static void backTrack(int i, int count){
    if(i == e){
      int diff = 0;
      for(int j = 0; j < g; j++){
        for(int k = 0; k < n; k++){
          visited[k] = false;
        }
        if(dfs(0, p[j])){
          ++diff;
        }
      }
      best = Math.min(best, count + diff);
      return;
    }
    int v = edges[i][0], w = edges[i][1];
    G[v][w] = G[w][v] = false;
    backTrack(i + 1, count + 1);
    G[v][w] = G[w][v] = true;
    backTrack(i + 1, count);
  }

  private static boolean dfs(int s, int t){
    if(visited[s]){
      return false;
    }
    if(s == t){
      return true;
    }
    visited[s] = true;
    for(int i = 0; i < n; i++){
      if(G[s][i]){
        if(dfs(i, t)){
          return true;
        }
      }
    }
    return false;
  }

}
