import java.util.Arrays;

class MinimumCostFlow {
 public static final int INF
    = Integer.MAX_VALUE;
  private int N, M;
  private int S, T, F;
  private int[][] U;
  private int[][] C;

  private int value;
  private int[][] solution;

  public MinimumCostFlow(int n, int m,
      int[][] u, int[][] c, 
      int s, int t, int f){
    this.N = n; this.M = m;
    this.U = u; this.C = c;
    this.S = s; this.T = t; this.F = f;
  }

  public void optimize(){
    solution = new int[N][N];
    for(int i = 0; i < U.length; i++){
      for(int j = 0; j < U[i].length; j++){
        solution[i][j] = U[i][j];
      }
    }

    int f = F, sum = 0;
    while(f > 0){
      // bellman-ford
      int[] dist = new int[N], prev = new int[N];
      Arrays.fill(dist, INF);
      dist[S] = 0;  prev[S] = -1;
      boolean update = true;
      while(update){
        update = false;
        for(int v = 0; v < N; v++){
          if(dist[v] == INF){
            continue;
          }
          for(int w = 0; w < N; w++){
            if(solution[v][w] > 0 && dist[w] > dist[v] + C[v][w]){
              dist[w] = dist[v] + C[v][w];  prev[w] = v;
              update = true;
            }
          }
        }
      }

      if(dist[T] == INF){
        value = -1;
        return;
      }

      int d = f;
      for(int i = T; prev[i] != -1; i = prev[i]){
        d = Math.min(d, solution[prev[i]][i]);
      }
      f -= d;
      sum += d * dist[T];

      for(int i = T; prev[i] != -1; i = prev[i]){
        solution[prev[i]][i] -= d;
        solution[i][prev[i]] += d;
      }
    }

    value = sum;
    for(int i = 0; i < solution.length; i++){
      for(int j = 0; j < solution[i].length; j++){
        if(U[i][j] > 0){
          solution[i][j] = U[i][j] - solution[i][j];
        }
      }
    }
  }

  public int getValue(){
    return value;
  }

  public int[][] getSolution(){
    return solution;
  }
}
