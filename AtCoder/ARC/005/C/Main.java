import java.util.Scanner;
import java.util.Arrays;
import java.util.Stack;

public class Main {
  static int h, w;
  static char[][] c;

  static int[][] color;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt(); w = sc.nextInt();
    c = new char[512][512];
    for(int i = 0; i < h; i++){
      String l = sc.next();
      for(int j = 0; j < w; j++){
        c[i][j] = l.charAt(j);
      }
    }

    int sx = -1, sy = -1, gx = -1, gy = -1;
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        if(c[i][j] == 's'){
          sx = j; sy = i;
        }
        else if(c[i][j] == 'g'){
          gx = j; gy = i;
        }
      }
    }

    color = new int[512][512];
    for(int i = 0; i < h; i++){
      Arrays.fill(color[i], -1);
    }

    color[sy][sx] = 0;
    dfs(sx, sy, 0);
    if(color[gy][gx] == 0){
      System.out.println("YES");
      return;
    }

    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
    for(int y = 0; y < h; y++){
      for(int x = 0; x < w; x++){
        if(c[y][x] != '#'){
          continue;
        }
        for(int k = 0; k < 4; k++){
          int nx = x + dx[k], ny = y + dy[k];
          if(0 <= nx && nx < w && 0 <= ny && ny < h){
            if(color[ny][nx] == 0 && color[y][x] == -1){
              color[y][x] = 1;
              dfs(x, y, 1);
            }
          }
        }
      }
    }

    if(color[gy][gx] == 1){
      System.out.println("YES");
      return;
    }

    for(int y = 0; y < h; y++){
      for(int x = 0; x < w; x++){
        if(c[y][x] != '#'){
          continue;
        }
        for(int k = 0; k < 4; k++){
          int nx = x + dx[k], ny = y + dy[k];
          if(0 <= nx && nx < w && 0 <= ny && ny < h){
            if(color[ny][nx] == 1 && color[y][x] == -1){
              color[y][x] = 2;
              dfs(x, y, 2);
            }
          }
        }
      }
    }

    if(color[gy][gx] == 2){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }

  private static void dfs(int sx, int sy, int cc){
    Stack< Pair > stack = new Stack< Pair >();
    int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};

    stack.push(new Pair(sx, sy));
    while(!stack.isEmpty()){
      Pair p = stack.pop();
      int x = p.s, y = p.t;
      for(int i = 0; i < 4; i++){
        int nx = x + dx[i], ny = y + dy[i];
        if(0 <= nx && nx < w && 0 <= ny && ny < h &&
            color[ny][nx] == -1 && c[ny][nx] != '#'){
          color[ny][nx] = cc;
          stack.push(new Pair(nx, ny));
        }
      }
    }
  }

  static class Pair {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }
  }
}
