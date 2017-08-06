import java.util.Scanner;

public class Main{
  static int h, w, n;
  static int[] a;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt();
    w = sc.nextInt();
    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int[][] table = new int[h][w];
    int r = 0, c = 0;
    boolean flag = false;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < a[i]; j++){
        if(DEBUG){
          System.out.println("r = " + r + " c = " + c);
        }
        table[r][c] = i + 1;
        if(!flag){
          if(c + 1 == w){
            r++;
            flag = !flag;
          }
          else{
            ++c;
          }
        }
        else{
          if(c - 1 == -1){
            ++r;
            flag = !flag;
          }
          else{
            --c;
          }
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        sb.append(table[i][j] + " ");
      }
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }
}
