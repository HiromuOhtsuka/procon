mport java.util.Scanner;

public class Main {
  static final int BLACK = 2;
  static final int WHITE = 1;

  static int W, H;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      W = scan.nextInt();
      H = scan.nextInt();
      if(W == 0)
        break;
      int[][] tableB, tableW;
      tableB = new int[H][W];
      tableW = new int[H][W];
      for(int i=0;i<H;i++){
        String line = scan.next();
        for(int j=0;j<W;j++){
          char ch = line.charAt(j);
          switch(ch){
            case '.':tableB[i][j] = tableW[i][j]= 0;break;
            case 'B':tableB[i][j] = tableW[i][j] = BLACK;break;
            case 'W':tableB[i][j] = tableW[i][j] = WHITE;break;
          }
        }
      }
      int[] ans = countSurroundingArea(tableB, tableW);
      System.out.print(ans[0] + " ");
      System.out.println(ans[1]);
    }
  }


  static int[] countSurroundingArea(int[][] tableB, int[][] tableW){
    searchColorAndDraw(tableB, BLACK);
    searchColorAndDraw(tableW, WHITE);
    int[] ans = new int[2];
    ans[0] = ans[1] = 0;
    for(int i=0;i<H;i++){
      for(int j=0;j<W;j++){
        if(tableB[i][j] == BLACK && tableW[i][j] == 0){
          ans[0]++;
        }
        if(tableB[i][j] == 0 && tableW[i][j] == WHITE){
          ans[1]++;
        }
      }
    }
    return ans;
  }

  static void searchColorAndDraw(int[][] table, int color){
    for(int i=0;i<H;i++){
      for(int j=0;j<W;j++){
        if(table[i][j] == color){
          draw(table, j, i, color);
        }
      }
    }
  }

  static void draw(int[][] table, int x, int y, int color){
    if(table[y][x] == 0)
      table[y][x] = color;
    if(x+1 < W && table[y][x+1] == 0)
      draw(table, x+1, y, color);
    if(x-1 >= 0 && table[y][x-1] == 0)
      draw(table, x-1, y, color);
    if(y+1 < H && table[y+1][x] == 0)
      draw(table, x, y+1, color);
    if(y-1 >= 0 && table[y-1][x] == 0)
      draw(table, x, y-1, color);
  }

}
