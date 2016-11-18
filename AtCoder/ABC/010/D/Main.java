import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  static int n, c, m;
  static int[] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); c = sc.nextInt(); m = sc.nextInt();
    p = new int[c];
    for(int i = 0; i < c; i++){
      p[i] = sc.nextInt();
    }

    int[][] u = new int[n + 1][n + 1];
    for(int i = 0; i < m; i++){
      int v = sc.nextInt(), w = sc.nextInt();
      u[v][w] = u[w][v] = 1;
    }
    for(int i = 0; i < c; i++){
      u[p[i]][n] = u[n][p[i]] = 1;
    }

    MaximumFlow mf = new MaximumFlow(n + 1, m, u, 0, n);
    mf.optimize();

    int ans = mf.getValue();

    System.out.println(ans);
  }
}

class MaximumFlow {
  public static final int INF 
    = Integer.MAX_VALUE;
  private int N, M;
  private int[][] U;
  private int S, T;

  private int value;
  private int[][] solution;

  public MaximumFlow(int n, int m, int[][] u, 
      int s, int t){
    this.N = n; this.M = m;
    this.S = s; this.T = t;
    this.U = u;
  }

  public int getValue(){
    return value;
  }

  public int[][] getSolution(){
    return solution;
  }

  public void optimize(){
    solution = new int[N][N];
    for(int i = 0; i < U.length; i++){
      for(int j = 0; j < U[i].length; j++){
        this.solution[i][j] = U[i][j];
      }
    }

    int flow = 0;
    for(;;){
      int[] prev = new int[N];
      int f = bfs(S, T, prev);
      if(f == 0){
        break;
      }
      for(int i = T; prev[i] != -1; i = prev[i]){
        solution[prev[i]][i] -= f;
        solution[i][prev[i]] += f;
      }
      flow += f;
    }

    value = flow;
    for(int i = 0; i < solution.length; i++){
      for(int j = 0; j < solution[i].length; j++){
        if(U[i][j] > 0){
          solution[i][j] = U[i][j] - solution[i][j];
        }
      }
    }
  }

  private int bfs(int s, int t, int[] prev){
    boolean[] visited = new boolean[N];
    int[] min = new int[N];
    Queue< Integer > queue 
      = new LinkedList< Integer >();

    Arrays.fill(min, INF);
    queue.offer(s);
    prev[s] = -1;
    while(!queue.isEmpty()){
      int v = queue.poll();
      if(v == t){
        return min[t];
      }
      visited[v] = true;
      for(int i = 0; i < N; i++){
        if(!visited[i] && solution[v][i] > 0){
          min[i] = Math.min(min[v], solution[v][i]);
          prev[i] = v;
          queue.offer(i);
        }
      }
    }
    return 0;
  }

}
