import java.util.Scanner;

public final class Main {
  public static final char BLACK = '.';
  public static final char RED = '#';
  public static final char MAN = '@';
  private int W, H;
  private char[][] map;
  private static final char PAINTED = '*';
  private int step;

  public Main(){
    Scanner scan = new Scanner(System.in);

    W = scan.nextInt();   H = scan.nextInt();
    while(W != 0 && H != 0){
      map = new char[H][];
      int sx = -1, sy = -1;
      for(int i = 0; i < map.length; i++){
        String sub = scan.next();
        map[i] = sub.toCharArray();
        int tmpi = sub.indexOf(MAN);
        if(tmpi != -1){
          sx = tmpi;    sy = i;
        }
      }
      map[sy][sx] = BLACK;
      step = 0;
      dfs(sx, sy);
      System.out.println(step);
      W = scan.nextInt();   H = scan.nextInt();
    }
  }

  private void dfs(int sx, int sy){
    if(!((0 <= sx && sx < W) && (0 <= sy && sy < H))){
      return;
    }
    if(map[sy][sx] != BLACK){
      return;
    }
    if(map[sy][sx] == PAINTED){
      return;
    }
    map[sy][sx] = PAINTED;    ++step;
    dfs(sx - 1, sy);    dfs(sx + 1, sy);
    dfs(sx, sy - 1);    dfs(sx, sy + 1);
  }

  public static void main(String[] args){
    new Main();
  }
}
