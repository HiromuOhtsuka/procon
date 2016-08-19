import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int r, c;
  static int sx, sy, gx, gy;
  static boolean[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); c = sc.nextInt();
    sy = sc.nextInt() - 1;  sx = sc.nextInt() - 1;
    gy = sc.nextInt() - 1; gx = sc.nextInt() - 1;

    table = new boolean[r][c];
    for(int i = 0; i < r; i++){
      String line = sc.next();
      for(int j = 0; j < c; j++){
        if(line.charAt(j) == '#'){
          table[i][j] = false;
        }
        else{
          table[i][j] = true;
        }
      }
    }

    Queue< E > que = new LinkedList< E >();
    que.offer(new E(sx, sy, 0));
    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    int ans = 0;
    while(!que.isEmpty()){
      E e = que.poll();
      if(!table[e.y][e.x]){
        continue;
      }
      table[e.y][e.x] = false;
      if(e.x == gx && e.y == gy){
        ans = e.d;
        break;
      }
      for(int i = 0; i < 4; i++){
        int nx = e.x + dx[i], ny = e.y + dy[i];
        if(0 <= nx && nx < c && 0 <= ny && ny < r &&
          table[ny][nx]){
          que.offer(new E(nx, ny, e.d + 1));
        }
      }
    }

    System.out.println(ans);
  }

  static class E {
    int x, y, d;

    E(int x, int y, int d){
      this.x = x; this.y = y;
      this.d = d;
    }
  }
}
