import java.util.Scanner;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static final int MAX_N = 1000;
  static int W, H, N;
  static int[] X1, X2, Y1, Y2;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      W = scan.nextInt() * 2 + 1; H = scan.nextInt() * 2 + 1;
      if(W == 1 && H == 1){
        return;
      }
      N = scan.nextInt();
      X1 = new int[N];  X2 = new int[N];
      Y1 = new int[N];  Y2 = new int[N];
      for(int i = 0; i < N; i++){
        X1[i] = scan.nextInt() * 2; Y1[i] = scan.nextInt() * 2;
        X2[i] = scan.nextInt() * 2; Y2[i] = scan.nextInt() * 2;
      }

      W = compress(X1, X2, W);
      H = compress(Y1, Y2, H);

      boolean[][] field = new boolean[6*N][6*N];
      for(int i = 0; i < N; i++){
        for(int y = Y1[i]; y <= Y2[i]; y++){
          for(int x = X1[i]; x <= X2[i]; x++){
            field[y][x] = true;
          }
        }
      }

      int count = 0;
      for(int i = 0; i < H; i++){
        for(int j = 0; j < W; j++){
          if(field[i][j]){
            continue;
          }
          ++count;
          Queue< int[] > queue = new LinkedList< int[] >();
          queue.offer(new int[]{j, i});
          while(!queue.isEmpty()){
            int[] p = queue.poll();
            int x = p[0], y = p[1];
            if(!(0 <= x && x < W && 0 <= y && y < H)){
              continue;
            }
            if(field[y][x]){
              continue;
            }
            field[y][x] = true;
            queue.offer(new int[]{x - 1, y}); queue.offer(new int[]{x + 1, y});
            queue.offer(new int[]{x, y - 1}); queue.offer(new int[]{x, y + 1});
          }
        }
      }

      System.out.println(count);
    }
  }

  static int compress(int[] x1, int[] x2, int w){
    int[] x = new int[6*N];
    int size = 0;

    for(int i = 0; i < N; i++){
      for(int d = -1; d <= 1; d++){
        int nx1 = x1[i] + d, nx2 = x2[i] + d;
        if(0 <= nx1 && nx1 < w){
          x[size++] = nx1;
        }
        if(0 <= nx2 && nx2 < w){
          x[size++] = nx2;
        }
      }
    }

    for(int i = 0; i < size; i++){
      if(x[i] == Integer.MAX_VALUE){
        continue;
      }
      for(int j = 0; j < size; j++){
        if(j != i && x[i] == x[j]){
          x[j] = Integer.MAX_VALUE;
        }
      }
    }

    Arrays.sort(x, 0, size);
    while(size - 1 >= 0 && x[size - 1] == Integer.MAX_VALUE){
      --size;
    }

    for(int i = 0; i < N; i++){
      x1[i] = Arrays.binarySearch(x, 0, size, x1[i]);
      x2[i] = Arrays.binarySearch(x, 0, size, x2[i]);
    }

    return size;
  }
}
