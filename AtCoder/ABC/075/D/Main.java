import java.util.Scanner;

public class Main{
  static int n, k;
  static int[] x, y;
  static final long INF = Long.MAX_VALUE / 2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    x = new int[n];
    y = new int[n];
    for(int i = 0; i < n; i++){
      x[i] = sc.nextInt();
      y[i] = sc.nextInt();
    }

    long min = INF;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        for(int kk = 0; kk < n; kk++){
          for(int l = 0; l < n; l++){
            int x1 = Math.min(x[i], x[j]);
            int x2 = Math.max(x[i], x[j]);
            int y1 = Math.min(y[kk], y[l]);
            int y2 = Math.max(y[kk], y[l]);
            int count = 0;
            for(int m = 0; m < n; m++){
              if(x1 <= x[m] && x[m] <= x2 &&
                y1 <= y[m] && y[m] <= y2){
                ++count;
              }
            }
            if(count >= k){
              min = Math.min(min, (long)(x2 - x1) * (long)(y2 - y1));
            }
          }
        }
      }
    }

    System.out.println(min);
  }
}
