import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n, k, p;
  static int[][][] a;
  static final int INF = Integer.MAX_VALUE;
  static int[] lineX;
  static int[] lineY;
  static int spx, spy;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // input
    n = sc.nextInt();
    for(int t = 0; t < n; t++){
      k = sc.nextInt(); p = sc.nextInt();
      a = new int[k][p][2];

      int minX = INF, minY = INF,
          maxX = -1, maxY = -1;
      for(int i = 0; i < k; i++){
        for(int j = 0; j < p; j++){
          int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
          a[i][j][0] = x; a[i][j][1] = y;
          minX = Math.min(minX, x);
          maxX = Math.max(maxX, x);
          minY = Math.min(minY, y);
          maxY = Math.max(maxY, y);
        }
      }

      // find rect
      Rect[] rects = new Rect[k];
      for(int i = 0; i < k; i++){
        Rect rect = new Rect(INF, INF, -1, -1);
        for(int j = 0; j < p; j++){
          rect.up = Math.min(rect.up, a[i][j][1]);
          rect.left= Math.min(rect.left, a[i][j][0]);
          rect.down = Math.max(rect.down, a[i][j][1]);
          rect.right = Math.max(rect.right, a[i][j][0]);
        }
        rects[i] = rect;
      }

      Event[] event = new Event[2 * k];
      int sp = 0;
      for(int i = 0; i < k; i++){
        event[sp++] = new Event(true, rects[i].left);
        event[sp++] = new Event(false, rects[i].right);
      }
      Arrays.sort(event);

      // line x
      lineX = new int[k + 2]; spx = 0;
      int count = 0;
      lineX[spx++] = minX;
      for(int i = 0; i < sp; i++){
        if(event[i].opening){
          ++count;
        }
        else{
          --count;
          if(count == 0){
            lineX[spx++] = event[i].x;
          }
        }
      }
      lineX[spx++] = maxX + 1;

      sp = 0;
      for(int i = 0; i < k; i++){
        event[sp++] = new Event(true, rects[i].up);
        event[sp++] = new Event(false, rects[i].down);
      }

      Arrays.sort(event);

      // line y
      lineY = new int[k + 2]; spy = 0;  count = 0;
      lineY[spy++] = minY;
      for(int i = 0; i < sp; i++){
        if(event[i].opening){
          ++count;
        }
        else{
          --count;
          if(count == 0){
            lineY[spy++] = event[i].x;
          }
        }
      }
      lineY[spy++] = maxY + 1;

      // count
      int[][] counts = new int[spy - 1][spx - 1];
      for(int i = 0; i < spy - 1; i++){
        int up = lineY[i], down = lineY[i + 1];
        for(int j = 0; j < spx - 1; j++){
          int left = lineX[j], right = lineX[j + 1];
          for(int l = 0; l < k; l++){
            if(rects[l].left >= left &&
                rects[l].right + 1 <= right &&
                rects[l].up >= up &&
                rects[l].down + 1 <= down){
              ++counts[i][j];
            }
          }
        }
      }

      // check
      boolean can = true;
      for(int i = 0; i < spy - 1; i++){
        for(int j = 0; j < spx - 1; j++){
          // check count[i][j] == 0 or 1
          if(counts[i][j] >= 2){
            can = false;
            break;
          }
        }
      }

      // output
      if(can){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
  }

  static class Rect {
    int up, left, down, right;

    // up: minY, left: minX
    // down: maxY, right: maxX
    Rect(int up, int left, int down, int right){
      this.up = up; this.left = left;
      this.down = down; this.right = right;
    }
  }

  static class Event implements Comparable< Event > {
    boolean opening;
    int x;

    Event(boolean opening, int x){
      this.opening = opening;
      this.x = x;
    }

    @Override
      public int compareTo(Event event){
        return x - event.x;
      }
  }
}

