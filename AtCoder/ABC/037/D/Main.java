import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int H, W;
  static int[][] table;
  static int[][] dp;
  static final int INF = Integer.MAX_VALUE / 2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    H = sc.nextInt(); W = sc.nextInt();
    table = new int[H][W];

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        table[i][j] = sc.nextInt();
      }
    }

    dp = new int[H][W];
    int sum = 0;
    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        sum = (sum + optimize(j, i)) % 1000000007;
      }
    }

    System.out.println(sum);
  }

  static int optimize(int x, int y){
    int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

    if(dp[y][x] > 0){
      return dp[y][x];
    }

    int ret = 1;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < W && 0 <= ny && ny < H &&
        table[y][x] > table[ny][nx]){
        ret = (ret + optimize(nx, ny)) % 1000000007;
      }
    }

    return dp[y][x] = ret;
  }


  static class Point {
     int x, y;

     Point(int x, int y){
       this.x = x;  this.y = y;
     }
  }

}
