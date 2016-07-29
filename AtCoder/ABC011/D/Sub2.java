import java.util.Scanner;

public class Sub2 {
  static int n, d, x, y;
  static int count;

  static int diff;
  static boolean[][][] visited;
  static long[][][] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); d = sc.nextInt();
    x = sc.nextInt(); y = sc.nextInt();

    if(x % d != 0 || y % d != 0){
      System.out.println(0.0);
      return;
    }

    if(n > 30){
      return;
    }

    x /= d; y /= d;
    dp = new long[n + 1][2 * n + 1][2 * n + 1];
    visited = new boolean[n + 1][2 * n + 1][2 * n + 1];
    backTrack(0, 0, 0);

    double p = (double)dp[0][0 + n][0 + n] / (double)(1L << (2L * (long)n));

    System.out.println(p);
  }

  private static long backTrack(int i, int nx, int ny){
    if(visited[i][n + nx][n + ny]){
      return dp[i][n + nx][n + ny];
    }
    visited[i][n + nx][n + ny] = true;
    if(i == n){
      if(nx == x && ny == y){
        return dp[i][n + nx][n + ny] = 1;
      }
      return 0;
    }
    long sum = 0;
    sum += backTrack(i + 1, nx + 1, ny);
    sum += backTrack(i + 1, nx - 1, ny);
    sum += backTrack(i + 1, nx, ny + 1);
    sum += backTrack(i + 1, nx, ny - 1);
    return dp[i][n + nx][n + ny] = sum;
  }
}
