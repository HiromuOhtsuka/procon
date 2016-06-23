import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int h, w, r, c;
  static int[][] horz, vert;
  static boolean[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    for(;;){
      h = sc.nextInt(); w = sc.nextInt();
      r = sc.nextInt(); c = sc.nextInt();

      if(h == 0 && w == 0 && r == 0 && c == 0){
        return;
      }

      horz = new int[h + 1][w];
      vert = new int[h][w + 1];
      for(int i = 0; i < 2 * h + 1; i++){
        if(i % 2 == 0){
          for(int j = 0; j < w; j++){
            horz[i / 2][j] = sc.nextInt();
          }
        }
        else{
          for(int j = 0; j < w + 1; j++){
            vert[i / 2][j] = sc.nextInt();
          }
        }
      }

      // debug
      /*
         for(int i = 0; i < 2 * h + 1; i++){
         if(i % 2 == 0){
         for(int j = 0; j < w; j++){
         System.out.print(" " + horz[i / 2][j]);
         }
         }
         else{
         for(int j = 0; j < w + 1; j++){
         System.out.print(" " + vert[i / 2][j]);
         }
         }
         System.out.println();
         }
       */

      Queue< Pair > que = new LinkedList< Pair >();
      table = new boolean[h + 2][w + 2];
      for(int j = 0; j < w + 2; j++){
        table[0][j] = table[h + 1][j] = true;
      }
      for(int j = 1; j <= w; j++){
        que.offer(new Pair(j, 1));
        que.offer(new Pair(j, h));
      }
      for(int i = 0; i < h + 2; i++){
        table[i][0] = table[i][w + 1] = true;
      }
      for(int i = 1; i <= h; i++){
        que.offer(new Pair(1, i));
        que.offer(new Pair(w, i));
      }

      int[] dx = new int[]{0, -1, 0, 1},
        dy = new int[]{-1, 0, 1, 0};
      while(!que.isEmpty()){
        Pair p = que.poll();
        int x = p.x, y = p.y;

        if(table[y][x]){
          continue;
        }

        int c1 = 0, c2 = 0;
        int uux = x, uuy = y - 1;
        int llx = x - 1, lly = y;
        int ddx = x, ddy = y + 1;
        int rrx = x + 1, rry = y;

        if(in(uux, uuy)){
          if(x - 1 >= 0 && y - 1 >= 0 && horz[y - 1][x - 1] == 1 && table[uuy][uux]){
            ++c1;
          }
          else if(x - 1 >= 0 && y - 1 >= 0 && horz[y - 1][x - 1] == 0 && table[uuy][uux]){
            ++c2;
          }
        }
        if(in(ddx, ddy)){
          if(ddx - 1 >= 0 && ddy - 1 >= 0 && horz[ddy - 1][ddx - 1] == 1 && table[ddy][ddx]){
            ++c1;
          }
          else if(ddx - 1 >= 0 && ddy - 1 >= 0 && horz[ddy - 1][ddx - 1] == 0 && table[ddy][ddx]){
            ++c2;
          }
        }
        if(in(llx, lly)){
          if(y - 1 >= 0 && x - 1 >= 0 && vert[y - 1][x - 1] == 1 && table[lly][llx]){
            ++c1;
          }
          else if(y - 1 >= 0 && x - 1 >= 0 && vert[y - 1][x - 1] == 0 && table[lly][llx]){
            ++c2;
          }
        }
        if(in(rrx, rry)){
          if(rrx - 1 >= 0 && rry - 1 >= 0 && vert[rry - 1][rrx - 1] == 1 && table[rry][rrx]){
            ++c1;
          }
          else if(rrx - 1 >= 0 && rry - 1 >= 0 && vert[rry - 1][rrx - 1] == 0 && table[rry][rrx]){
            ++c2;
          }
        }

        if(c1 >= 1 && c2 >= 1){
          table[y][x] = true;
          for(int i = 0; i < 4; i++){
            int nx = x + dx[i], ny = y + dy[i];
            que.offer(new Pair(nx, ny));
          }
        }
      }

      /*
         for(int i = 0; i < h + 2; i++){
         for(int j = 0; j < w + 2; j++){
         System.out.print(" " + (table[i][j] ? "1" : "0"));
         }
         System.out.println();
         }
       */
      boolean flag = false;
        int uux = c, uuy = r - 1;
        int llx = c - 1, lly = r;
        int ddx = c, ddy = r + 1;
        int rrx = c + 1, rry = r;

        if(in(uux, uuy)){
          if(c - 1 >= 0 && r - 1 >= 0 && horz[r - 1][c - 1] == 0 && table[uuy][uux]){
            flag = true;
          }
        }
        if(in(ddx, ddy)){
          if(ddx - 1 >= 0 && ddy - 1 >= 0 && horz[ddy - 1][ddx - 1] == 0 && table[ddy][ddx]){
            flag = true;
          }
        }
        if(in(llx, lly)){
          if(r - 1 >= 0 && c - 1 >= 0 && vert[r - 1][c - 1] == 0 && table[lly][llx]){
            flag = true;
          }
        }
        if(in(rrx, rry)){
          if(rrx - 1 >= 0 && rry - 1 >= 0 && vert[rry - 1][rrx - 1] == 0 && table[rry][rrx]){
            flag = true;
          }
        }

      if(flag){
        System.out.println("Yes");
      }
      else{
        System.out.println("No");
      }
    }
  }

  private static boolean in(int x, int y){
    return 0 <= x && x < w + 2 &&
      0 <= y && y < h + 2;
  }

  private static boolean in1(int x, int y){
    return 1 <= x && x <= w &&
      1 <= y && y <= h;
  }

  static class Pair {
    int x, y;

    Pair(int x, int y){
      this.x = x; this.y = y;
    }
  }
}
