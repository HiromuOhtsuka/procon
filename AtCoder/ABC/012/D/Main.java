import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, m;
  static int[][] G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    G = new int[n][n];
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1, t = sc.nextInt();
      G[a][b] = G[b][a] = t;
    }

    long[][] dist = new long[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(i == j){
          dist[i][j] = 0;
        }
        else if(G[i][j] > 0){
          dist[i][j] = G[i][j];
        }
        else{
          dist[i][j] = INF;
        }
      }
    }

    for(int k = 0; k < n; k++){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    long min = INF;
    for(int i = 0; i < n; i++){
      long max = 0;
      for(int j = 0; j < n; j++){
        max = Math.max(max, dist[i][j]);
      }
      min = Math.min(min, max);
    }

    System.out.println(min);
  }
}
