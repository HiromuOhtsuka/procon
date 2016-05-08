import java.util.Scanner;

public class Main {
  int N, M, P, A, B;
  int[] T;
  int[][] dist;

  public Main(){
    Scanner scan = new Scanner(System.in);

    for(;;){
      N = scan.nextInt(); M = scan.nextInt(); P = scan.nextInt();
      A = scan.nextInt(); B = scan.nextInt();

      if(N == 0 && M == 0 && P == 0 && A == 0 && B == 0){
        break;
      }

      T = new int[N];
      for(int i = 0; i < N; i++){
        T[i] = scan.nextInt();
      }

      dist = new int[M][M];
      for(int i = 0; i < M; i++){
        for(int j = 0; j < M; j++){
          dist[i][j] = Integer.MAX_VALUE >> 1;
        }
      }

      for(int i = 0; i < P; i++){
        int x = scan.nextInt(), y = scan.nextInt(), z = scan.nextInt();
        dist[x - 1][y - 1] = dist[y - 1][x - 1] = z;
      }

      final double INF = 100 * 100 + 1;

      double[][] dp = new double[1 << N][M];
      for(int i = 0; i < (1 << N); i++){
        for(int j = 0; j < M; j++){
          dp[i][j] = INF;
        }
      }
      dp[(1 << N) - 1][A - 1] = 0;
      double ans = INF;
      for(int s = (1 << N) - 1; s >= 0; s--){
        ans = Math.min(ans, dp[s][B - 1]);
        for(int v = 0; v < M; v++){
          for(int i = 0; i < N; i++){
            if(((1 << i) & s) != 0){
              for(int u = 0; u < M; u++){
                dp[s & ~(1 << i)][u] = 
                  Math.min(dp[s][v] + (double)dist[v][u] / (double)T[i], dp[s & ~(1 << i)][u]);
              }
            }
          }
        }
      }

      final double ESP = 1e-4;
      if(Math.abs(ans - INF) <= ESP){
        System.out.println("Impossible");
      }
      else{
        System.out.printf("%.3f\n", ans);
      }
    }

  }

  public static void main(String[] args){
    new Main();
  }
}
