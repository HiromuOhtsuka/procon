import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public final class Main {
  public static final int MAX_X = 310;
  public static final int MAX_Y = 310;
  private int M;
  private int[][] table;
  private int best;
  private int[][] dist;

  private static final class Coordinate {
    private int x, y, t;

    Coordinate(int x, int y, int t){
      this.x = x;   this.y = y;
      this.t = t;
    }

    int getX(){
      return x;
    }

    int getY(){
      return y;
    }

    int getT(){
      return t;
    }
  }

  public Main(){
    Scanner scan = new Scanner(System.in);
    table = new int[MAX_Y + 1][MAX_X + 1];
    dist = new int[MAX_Y + 1][MAX_X + 1];
    for(int i = 0; i < table.length; i++){
      for(int j = 0; j < table[i].length; j++){
        table[i][j] = dist[i][j] = Integer.MAX_VALUE;
      }
    }

    M = scan.nextInt();
    for(int i = 0; i < M; i++){
      int x, y, t;
      x = scan.nextInt();
      y = scan.nextInt();
      t = scan.nextInt();
      update(x, y, t);
      update(x - 1, y, t);
      update(x + 1, y, t);
      update(x, y + 1, t);
      update(x, y - 1, t);
    }

    bfs();
    if(best != Integer.MAX_VALUE){
      System.out.println(best);
    }
    else{
      System.out.println(-1);
    }

/*
    for(int i = 0; i < dist.length; i++){
      for(int j = 0; j < dist[i].length; j++){
        if(dist[i][j] != Integer.MAX_VALUE){
          System.out.println("dist[" + i + "][" + j + "]:" + dist[i][j]);
        }
      }
    }
*/
  }

  private void bfs(){
    best = Integer.MAX_VALUE;
    Queue< Coordinate > que = new LinkedList< Coordinate >();

    dist[0][0] = 0;
    que.add(new Coordinate(0, 0, 0));
    while(!que.isEmpty()){
      Coordinate c = que.poll();
      int x = c.getX(), y = c.getY(), t = c.getT();
      if(dist[y][x] < t){
        continue;
      }
      if(table[y][x] == Integer.MAX_VALUE){
        best = t;
        break;
      }
      if(x + 1 <= MAX_X && !(t + 1 >= table[y][x + 1]) && dist[y][x + 1] > t + 1){
        dist[y][x + 1] = t + 1;
        que.offer(new Coordinate(x + 1, y, t + 1));
      }
      if(y + 1 <= MAX_Y && !(t + 1 >= table[y + 1][x]) && dist[y + 1][x] > t + 1){
        dist[y + 1][x] = t + 1;
        que.offer(new Coordinate(x, y + 1, t + 1));
      }
      if(0 <= x - 1 && !(t + 1 >= table[y][x - 1]) && dist[y][x - 1] > t + 1){
        dist[y][x - 1] = t + 1;
        que.offer(new Coordinate(x - 1, y, t + 1));
      }
      if(0 <= y - 1 && !(t + 1 >= table[y - 1][x]) && dist[y - 1][x] > t + 1){
        dist[y - 1][x] = t + 1;
        que.offer(new Coordinate(x, y - 1, t + 1));
      }
    }
  }

  private void update(int x, int y, int t){
    if(!(0 <= x && x <= MAX_X && 0 <= y && y <= MAX_Y)){
      return;
    }
    if(table[y][x] > t){
      table[y][x] = t;
    }
  }

  public static void main(String[] args){
    new Main();
  }
}
