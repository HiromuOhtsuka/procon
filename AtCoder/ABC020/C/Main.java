import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int h, w, t;
  static int sx, sy, gx, gy;
  static char[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt(); w = sc.nextInt(); t = sc.nextInt();
    table = new char[h][w];
    for(int i = 0; i < h; i++){
      String line = sc.next();
      for(int j = 0; j < w; j++){
        char ch = line.charAt(j);
        table[i][j] = ch;
        if(ch == 'S'){
          sx = j; sy = i;
        }
        if(ch == 'G'){
          gx = j; gy = i;
        }
      }
    }

    int low = -1, high = INF;
    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    while(high - low > 1){
      int mid = (low + high) / 2;
      if(f(mid)){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.println(low);
  }

  private static boolean f(int mid){
    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    PriorityQueue< Pair > pq = new PriorityQueue< Pair >();
    int[][] dist = new int[h][w];

    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        dist[i][j] = INF;
      }
    }

    pq.offer(new Pair(sx, sy, 0));
    while(!pq.isEmpty()){
      Pair p = pq.poll();
      if(dist[p.y][p.x] > p.d){
        dist[p.y][p.x] = p.d;
      }
      else{
        continue;
      }
      for(int i = 0; i < 4; i++){
        int nx = p.x + dx[i], ny = p.y + dy[i];
        if(0 <= nx && nx < w && 0 <= ny && ny < h){
          if(table[ny][nx] == '#'){
            pq.offer(new Pair(nx, ny, p.d + mid));
          }
          else{
            pq.offer(new Pair(nx, ny, p.d + 1));
          }
        }
      }
    }

    return dist[gy][gx] <= t;
  }

  static class Pair implements Comparable< Pair > {
    int x, y, d;

    Pair(int x, int y, int d){
      this.x = x; this.y = y;
      this.d = d;
    }

    @Override
      public int compareTo(Pair p){
        return d - p.d;
      }
  }
}
