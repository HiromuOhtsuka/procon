import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static int[][] a;
  static int[][] dist;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = new int[n][n];
    for(int i = 0; i < m; i++){
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1,
          l = sc.nextInt();
      a[u][v] = a[v][u] = l;
    }

    dist = new int[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(i != j){
          if(a[i][j] > 0){
            dist[i][j] = a[i][j];
          }
          else{
            dist[i][j] = INF;
          }
        }
        else{
          dist[i][j] = 0;
        }
      }
    }

    for(int k = 1; k < n; k++){
      for(int i = 1; i < n; i++){
        for(int j = 1; j < n; j++){
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    int min = INF;
    for(int i = 1; i < n; i++){
      for(int j = i + 1; j < n; j++){
        if(a[0][i] > 0 && a[0][j] > 0){
          min = Math.min(min, dist[i][j] + a[0][i] + a[0][j]);
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
}
