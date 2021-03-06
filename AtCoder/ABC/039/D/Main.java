import java.util.Scanner;

public class Main {
  static int h, w;
  static char[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = sc.nextInt(); w = sc.nextInt();
    table = new char[h][];
    sc.nextLine();
    for(int i = 0; i < h; i++){
      table[i] = sc.nextLine().toCharArray();
    }

    char[][] ori = new char[h][w];
    char[][] mem = new char[h][w];
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        ori[i][j] = mem[i][j] = '#';
      }
    }

    int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1},
      dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        if(table[i][j] == '.'){
          for(int k = 0; k < 8; k++){
            int ni = i + dy[k], nj = j + dx[k];
            if(0 <= ni && ni < h &&
                0 <= nj && nj < w){
              ori[ni][nj] = mem[ni][nj] = '.';
            }
          }
          ori[i][j] = mem[i][j] = '.';
        }
      }
    }

    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        boolean flag = false;
        for(int k = 0; k < 8; k++){
          int ni = i + dy[k], nj = j + dx[k];
          if(0 <= ni && ni < h &&
              0 <= nj && nj < w &&
              ori[ni][nj] == '#'){
            flag = true;
          }
        }
        if(flag){
          mem[i][j] = '#';
        }
      }
    }

    boolean possible = true;
    for(int i = 0; i < h; i++){
      for(int j = 0; j < w; j++){
        if(table[i][j] != mem[i][j]){
          possible = false;
          break;
        }
      }
    }


    if(possible){
      System.out.println("possible");
      for(int i = 0; i < h; i++){
        System.out.println(ori[i]);
      }
    }
    else{
      System.out.println("impossible");
    }
  }
}
