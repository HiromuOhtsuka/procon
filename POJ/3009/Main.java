import java.util.Scanner;

public final class Main {
  private int W, H;
  private static final int VACANT = 0;
  private static final int BLOCK = 1;
  private static final int START = 2;
  private static final int GOAL = 3;
  private int[][] map;
  private static final int INF = Integer.MAX_VALUE;
  private int step;
  private int best;

  public Main(){
    Scanner scan = new Scanner(System.in);

    W = scan.nextInt();   H = scan.nextInt();
    while(W != 0 && H != 0){
      map = new int[H][W];
      int sx = -1, sy = -1;
      for(int i = 0; i < map.length; i++){
        for(int j = 0; j < map[i].length; j++){
          map[i][j] = scan.nextInt();
          if(map[i][j] == START){
            sx = j;   sy = i;
          }
        }
      }
      step = 0;
      best = INF;
      if(dfs(sx, sy)){
        System.out.println(best);
      }
      else{
        System.out.println(-1);
      }
      W = scan.nextInt();   H = scan.nextInt();
    }
  }

  // 長い。もっと短い実装を。
/*
  private boolean dfs(int sx, int sy){
    //System.out.println("(sx, sy) : " + "(" + sx + ", " +  sy + ")");
    if(step > best){
      return false;
    }
    if(!((0 <= sx && sx < W) && (0 <= sy && sy < H))){
      return false;
    }
    if(map[sy][sx] == GOAL){
      if(step < best){
        best = step;
      }
      return true;
    }
    // left
    int x = -1;
    for(int j = sx - 1; j >= 0; j--){
      if(map[sy][j] == BLOCK){
        x = j;
        break;
      }
      if(map[sy][j] == GOAL){
        ++step;
        dfs(j, sy);
        --step;
        return true;
      }
    }
    if(x != -1){
      map[sy][x] = VACANT;
      ++step;
      if(!dfs(x + 1, sy)){
        --step;
        map[sy][x] = BLOCK;
      }
      else{
        return true;
      }
    }
    // right
    x = W;
    for(int j = sx + 1; j < W; j++){
      if(map[sy][j] == BLOCK){
        x = j;
        break;
      }
      if(map[sy][j] == GOAL){
        ++step;
        dfs(j, sy);
        --step;
        return true;
      }
    }
    if(x != W){
      map[sy][x] = VACANT;
      ++step;
      if(!dfs(x - 1, sy)){
        --step;
        map[sy][x] = BLOCK;
      }
      else{
        return true;
      }
    }
    // up
    int y = -1;
    for(int i = sy - 1; i >= 0; i--){
      if(map[i][sx] == BLOCK){
        y = i;
        break;
      }
      if(map[i][sx] == GOAL){
        ++step;
        dfs(sx, i);
        --step;
        return true;
      }
    }
    if(y != -1){
      map[y][sx] = VACANT;
      ++step;
      if(!dfs(sx, y + 1)){
        --step;
        map[y][sx] = BLOCK;
      }
      else{
        --step;
        return true;
      }
    }
    // down
    y = H;
    for(int i = sy + 1; i < H; i++){
      if(map[i][sx] == BLOCK){
        y = i;
        break;
      }
      if(map[i][sx] == GOAL){
        ++step;
        return dfs(sx, i);
      }
    }
    if(y != H){
      map[y][sx] = VACANT;
      ++step;
      if(!dfs(sx, y - 1)){
        --step;
        map[y][sx] = BLOCK;
      }
      else{
        --step;
        return true;
      }
    }
    return false;
  }
  */

  public static void main(String[] args){
    new Main();
  }
}
