import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(), K = scan.nextInt();
    int[][] A = new int[K][];
    for(int i = 0; i < K; i++){
      int r = scan.nextInt(), c = scan.nextInt();
      A[i] = new int[]{r, c};
    }
    int[][] U = new int[2 + 2 * N][2 + 2 * N];
    // s -> r_i
    for(int i = 1; i <= N; i++){
      U[0][i] = 1;
    }
    // t -> c_i
    for(int i = N + 1; i <= 2 * N; i++){
      U[i][2 * N + 1] = 1;
    }
    for(int i = 0; i < K; i++){
      int r = A[i][0], c = A[i][1] + N;
      U[r][c] = 1;
    }

    MaximumFlow mf = new MaximumFlow(2 + 2 * N, 2 * N + K, U, 0, 2 * N + 1);
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

  public MaximumFlow(int n, int m, int[][] u, 
      int s, int t){
    this.N = n; this.M = m;
    this.S = s; this.T = t;
    this.U = u;
  }

  public int getValue(){
    return value;
  }

  public void optimize(){
    int flow = 0;
    for(;;){
      int[] prev = new int[N];
      int f = bfs(S, T, prev);
      if(f == 0){
        break;
      }
      for(int i = T; prev[i] != -1; i = prev[i]){
        U[prev[i]][i] -= f;
        U[i][prev[i]] += f;
      }
      flow += f;
    }

    value = flow;
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
        if(U[v][i] > 0 && !visited[i]){
          min[i] = Math.min(min[v], U[v][i]);
          prev[i] = v;
          queue.offer(i);
        }
      }
    }
    return 0;
  }

}
