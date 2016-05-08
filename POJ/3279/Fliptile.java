import java.util.Scanner;

public class Main {
  static int M, N;
  static int[][] a;
  static int[][] w;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    M = scan.nextInt(); N = scan.nextInt();
    a = new int[M][N];
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        a[i][j] = scan.nextInt();
      }
    }

    int best = -1;
    int[][] ans = new int[M][N];
    w = new int[M][N];
    for(int i = 0; i < (1 << N); i++){

      for(int j = 0; j < N; j++){
        if((i & (1 << j)) != 0){
          w[0][j] = 1;
        }
      }

      int m = search();
      if(m >= 0 && (best == -1 || best > m)){
        best = m;
        for(int j = 0; j < M; j++){
          for(int k = 0; k < N; k++){
            ans[j][k] = w[j][k];
          }
        }
      }

      for(int j = 0; j < M; j++){
        for(int k = 0; k < N; k++){
          w[j][k] = 0;
        }
      }
    }

    if(best == -1){
      System.out.println("IMPOSSIBLE");
    }
    else{
      for(int i = 0; i < M; i++){
        for(int j = 0; j < N; j++){
          System.out.print(ans[i][j] + ((j == N - 1) ? "\n" : " "));
        }
      }
    }
  }

  static int getColorAt(int x, int y){
    int[] dx = {-1, 0, 0, 1};
    int[] dy = {0, -1, 1, 0};

    int color = a[y][x] + w[y][x];
    for(int i = 0; i < 4; i++){
      if(0 <= (x + dx[i]) && (x + dx[i]) < N &&
          0 <= (y + dy[i]) && (y + dy[i]) < M){
        color += w[y + dy[i]][x + dx[i]];
      }
    }
    return color % 2;
  }

  static int search(){
    for(int i = 1; i < M; i++){
      for(int j = 0; j < N; j++){
        if(getColorAt(j, i - 1) == 1){
          w[i][j] = 1;
        }
      }
    }

    int count = 0;
    boolean pos = true;
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        if(getColorAt(j, i) == 1){
          pos = false;
        }
        count += w[i][j];
      }
    }

    return pos ? count : -1;
  }
}
