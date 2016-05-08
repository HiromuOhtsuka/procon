import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(), F = scan.nextInt(), D = scan.nextInt();
    /* 0 : s
     * 1 ~ F : food
     * F + 1 ~ F + N : cow
     * F + N + 1 ~ F + N + N : cow
     * F + 2 * N + 1 ~ F + 2 * N + D : drink
     * F + 2 * N + D + 1 : t
     */
    int[][] U = new int[2 + 2 * N + F + D][2 + 2 * N + F + D];
    for(int i = 1; i <= F; i++){
      U[0][i] = 1;
    }
    for(int i = F + 1; i <= F + N; i++){
      U[i][i + N] = 1;
    }
    for(int i = F + 2 * N + 1; i <= F + 2 * N + D; i++){
      U[i][F + 2 * N + D + 1] = 1;
    }
    int count = 0;
    for(int i = 1; i <= N; i++){
      int n = scan.nextInt(), m = scan.nextInt();
      count += n + m;
      for(int j = 0; j < n; j++){
        int f = scan.nextInt();
        U[f][i + F] = 1;
      }
      for(int j = 0; j < m; j++){
        int d = scan.nextInt();
        U[F + N + i][d + F + 2 * N] = 1;
      }
    }

    MaximumFlow mf = new MaximumFlow(2 + 2 * N + F + D, F + N + D + count, 
        U, 0, 2 + 2 * N + F + D - 1);
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
