import java.util.Scanner;

public class Main {
  static int n, k, p;
  static int[][][] a;
  static final int INF = Integer.MAX_VALUE;
  static int[] lineX;
  static int[] lineY;
  static int spx, spy;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

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

      lineX = new int[k + 2]; spx = 0;
      int count = 0, lastX = -1;
      lineX[spx++] = minX;
      for(int x = minX; x <= maxX; x++){
        for(int i = 0; i < k; i++){
          if(x == rects[i].left){
            ++count;
          }
          if(x == rects[i].right){
            --count;
          }
        }
        if(count == 0){
          lastX = Math.max(lastX, x);
        }
        else if(lastX != -1){
          lineX[spx++] = lastX;
          lastX = -1;
        }
      }
      lineX[spx++] = maxX;

      lineY = new int[k + 2]; spy = 0;  count = 0;
      int lastY = -1;
      lineY[spy++] = minY;
      for(int y = minY; y <= maxY; y++){
        for(int i = 0; i < k; i++){
          if(y == rects[i].up){
            ++count;
          }
          if(y == rects[i].down){
            --count;
          }
        }
        if(count == 0){
          lastY = Math.max(lastY, y);
        }
        else if(lastY != -1){
          lineY[spy++] = lastY;
          lastY = -1;
        }
      }
      lineY[spy++] = maxY;

      int[][] counts = new int[spy - 1][spx - 1];
      for(int i = 0; i < spy - 1; i++){
        int up = lineY[i], down = lineY[i + 1];
        for(int j = 0; j < spx - 1; j++){
          int left = lineX[j], right = lineX[j + 1];
          for(int l = 0; l < k; l++){
            if(rects[l].left >= left &&
                rects[l].right <= right &&
                rects[l].up >= up &&
                rects[l].down <= down){
              ++counts[i][j];
            }
          }
        }
      }

      boolean can = true;
      for(int i = 0; i < spy - 1; i++){
        for(int j = 0; j < spx - 1; j++){
          if(counts[i][j] >= 2){
            can = false;
            break;
          }
        }
      }

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

    Rect(int up, int left, int down, int right){
      this.up = up; this.left = left;
      this.down = down; this.right = right;
    }
  }
}
