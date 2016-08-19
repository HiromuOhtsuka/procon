import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int w, h;
  static int n;
  static int[] x, y;

  static int[][][][] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    w = sc.nextInt(); h = sc.nextInt();
    n = sc.nextInt();

    x = new int[n]; y = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt() - 1; y[i] = sc.nextInt() - 1;
    }

    dp = new int[h][w][h][w];
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        for(int k = 0; k < h; k++){
          Arrays.fill(dp[i][j][k], -1);
        }
      }
    }

    int ans = optimize(0, 0, h - 1, w - 1);

    System.out.println(ans);
  }

  private static int optimize(int i, int j, int k, int l){
    if(!(0 <= i && i < h && 0 <= j && j < w &&
          0 <= k && k < h && 0 <= l && l < w)){
      return 0;
    }

    if(dp[i][j][k][l] >= 0){
      return dp[i][j][k][l];
    }

    int max = 0;
    for(int w = 0; w < n; w++){
      if(j <= x[w] && x[w] <= l &&  i <= y[w] && y[w] <= k){
        int tmp = optimize(i, j, y[w] - 1, x[w] - 1) +
          optimize(y[w] + 1, j, k, x[w] - 1) +
          optimize(i, x[w] + 1, y[w] - 1, l) +
          optimize(y[w] + 1, x[w] + 1, k, l) + (l - j) + 1 + (k - i) + 1 - 1;
        max = Math.max(max, tmp);
      }
    }

    return dp[i][j][k][l] = max;
  }
}
