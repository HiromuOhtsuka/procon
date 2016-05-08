import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    final int INF = Integer.MAX_VALUE / 2;

    int N = sc.nextInt(), M = sc.nextInt();
    int[] D = new int[N];
    for(int i = 0; i < N; i++){
      D[i] = sc.nextInt();
    }
    int[] C = new int[M];
    for(int i = 0; i < M; i++){
      C[i] = sc.nextInt();
    }

    int[][] dp = new int[N + 1][M + 1];
    for(int i = 1; i <= N; i++){
      dp[i][0] = INF;
    }
    for(int i = 1; i <= N; i++){
      for(int j = 1; j <= M; j++){
        dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j - 1] + C[j - 1] * D[i - 1]);
      }
    }

    System.out.println(dp[N][M]);
  }
}
