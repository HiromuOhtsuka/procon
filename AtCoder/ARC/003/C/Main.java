import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;

public class Main {
  static int n, m;
  static char[][] table;

  static int sx, sy, gx, gy;
  static int[][] dist;
  static final int INF = Integer.MAX_VALUE / 2;
  static final double EPS = 1e-09;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    table = new char[n][m];
    for(int i = 0; i < n; i++){
      table[i] = sc.next().toCharArray();
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(table[i][j] == 's'){
          sx = j; sy = i;
        }
        if(table[i][j] == 'g'){
          gx = j; gy = i;
        }
      }
    }

    dist = new int[n][m];
    if(!f(-1)){
      System.out.println(-1);
      return;
    }

    double low = -EPS, high = 10;
    while(high - low > EPS){
      double mid = (low + high) / 2.0;
      if(f(mid)){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.println(low);
  }

  private static boolean f(double k){
    for(int i = 0; i < n; i++){
      Arrays.fill(dist[i], INF);
    }

    Queue< E > que = new LinkedList< E >();
    que.offer(new E(sx, sy, 0));

    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    while(!que.isEmpty()){
      E e = que.poll();
      if(e.x == gx && e.y == gy){
        return true;
      }
      double v = Math.pow(0.99, e.t) * (table[e.y][e.x] - '0');
      if(v < k){
        continue;
      }
      for(int i = 0; i < 4; i++){
        int nx = e.x + dx[i], ny = e.y + dy[i];
        if(0 <= nx && nx < m && 0 <= ny && ny < n &&
            table[ny][nx] != '#' &&
            dist[ny][nx] > e.t + 1){
          dist[ny][nx] = e.t + 1;
          que.offer(new E(nx, ny, e.t + 1));
        }
      }
    }
    return false;
  }

  static class E {
    int x, y, t;

    E(int x, int y, int t){
      this.x = x; this.y = y;
      this.t = t;
    }
  }
}
