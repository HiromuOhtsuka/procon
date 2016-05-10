import java.util.Scanner;

public class Main {
  static int[][] step = new int[5][6];
  static int[][] table = new int[5][6];

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();

    for(int i =  0; i < N; i++){

      for(int j = 0; j < 5; j++){
        for(int k = 0; k < 6; k++){
          table[j][k] = scan.nextInt();
        }
      }

      for(int s = 0; s < (1 << 5); s++){
        for(int j = 0; j < 5; j++){
          if((s & (1 << j)) != 0){
            step[j][0] = 1;
          }
        }
        for(int j = 1; j < 6; j++){
          for(int k = 0; k < 5; k++){
            if(f(j - 1, k) == 1){
              step[k][j] = 1;
            }
          }
        }
        boolean check = true;
        for(int j = 0; j < 5; j++){
          for(int k = 0; k < 6; k++){
            if(f(k, j) != 0){
              check = false;
              break;
            }
          }
        }
        if(check){
          System.out.println("PUZZLE #" + (i + 1));
          for(int j = 0; j < 5; j++){
            for(int k = 0; k < 6; k++){
              System.out.print(step[j][k] + ((k == 5) ? "\n" :" "));
            }
          }
          for(int j = 0; j < 5; j++){
            for(int k = 0; k < 6; k++){
              step[j][k] = 0;
            }
          }
          break;
        }

        for(int j = 0; j < 5; j++){
          for(int k = 0; k < 6; k++){
            step[j][k] = 0;
          }
        }
      }
    }
  }

  static int f(int x, int y){
    int[] dx = {0, -1, 0, 0, 1};
    int[] dy = {0, 0, -1, 1, 0};

    int w = table[y][x];
    for(int i = 0; i < 5; i++){
      if(0 <= x + dx[i] && x + dx[i] < 6 && 0 <= y + dy[i] && y + dy[i] < 5){
        w += step[y + dy[i]][x + dx[i]];
      }
    }

    return w % 2;
  }
}
