import java.util.Scanner;

public class Main {
  static int H, W;
  static int[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    H = sc.nextInt(); W = sc.nextInt();
    table = new int[H][W];
    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        table[i][j] = -1;
      }
    }
    sc.nextLine();
    for(int i = 0; i < H; i++){
      String line = sc.nextLine();
      for(int j = 0; j < line.length(); j++){
        if(line.charAt(j) == 'c'){
          table[i][j] = 0;
        }
      }
    }

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        if(table[i][j] == -1){
          for(int k = j - 1; k >= 0; k--){
            if(table[i][k] == 0){
              table[i][j] = j - k;
              break;
            }
          }
        }
      }
    }

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        System.out.print(table[i][j] + ((j == W - 1) ? "\n" : " "));
      }
    }
  }
}
