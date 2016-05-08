import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int H, W;
  static int[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    H = sc.nextInt(); W = sc.nextInt();
    table = new int[H][W];

    sc.nextLine();
    for(int i = 0; i < H; i++){
      String line = sc.nextLine();
      for(int j = 0; j < W; j++){
        char ch = line.charAt(j);
        if(ch != '.'){
          table[i][j] = ch - '0';
        }
      }
    }

    int wave = 0;
    int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}, 
      dy = {-1, -1, 0, 1, 1, 1, 0, -1};
    List< Integer[] > list = new ArrayList< Integer[] >();
      for(int i = 0; i < H; i++){
        for(int j = 0; j < W; j++){
          if(table[i][j] == 0){
            continue;
          }
          int count = 0;
          for(int k = 0; k < 8; k++){
            int nj = j + dx[k], ni = i + dy[k];
            if(0 <= nj && nj < W && 0 <= ni && ni < H){
              if(table[ni][nj] == 0){
                ++count;
              }
            }
          }
          if(count >= table[i][j]){
            list.add(new Integer[]{j, i});
          }
        }
      }
      if(!list.isEmpty()){
      for(Integer[] a : list){
        table[a[1]][a[0]] = 0;
        int i = a[1], j = a[0];
          for(int k = 0; k < 8; k++){
            int nj = j + dx[k], ni = i + dy[k];
            if(0 <= nj && nj < W && 0 <= ni && ni < H){
              if(table[ni][nj] == 0){
                ++count;
              }
            }
          }
      }

    System.out.println(wave);
  }
}
