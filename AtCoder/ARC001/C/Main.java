import java.util.Scanner;

public class Main {
  static char[][] c;
  static boolean[][] table;

  static int rs, cs;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    c = new char[8][8];
    for(int i = 0; i < 8; i++){
      String l = sc.next();
      for(int j = 0; j < 8; j++){
        c[i][j] = l.charAt(j);
      }
    }

    table = new boolean[8][8];
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(c[i][j] == 'Q'){
          table[i][j] = true;
          rs |= (1 << i);  cs |= (1 << j);
        }
      }
    }

    if(backTrack()){
      for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
          if(table[i][j]){
            System.out.print("Q");
          }
          else{
            System.out.print(".");
          }
        }
        System.out.println();
      }
    }
    else{
      System.out.println("No Answer");
    }
  }

  private static boolean backTrack(){
    if(rs == (1 << 8) - 1 || cs == (1 << 8) - 1){
      return check();
    }

    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if((rs & (1 << i)) == 0 && ((cs & (1 << j))) == 0){
          table[i][j] = true;
          rs |= 1 << i; cs |= 1 << j;
          if(backTrack()){
            return true;
          }
          table[i][j] = false;
          rs ^= 1 << i; cs ^= 1 << j;
        }
      }
    }

    return false;
  }

  private static boolean check(){
    int[] dx = new int[]{0, -1, -1, -1, 0, 1, 1, 1},
      dy = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};

    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        if(table[i][j]){
          for(int k = 0; k < 8; k++){
            for(int l = 1; l <= 8; l++){
              int ni = i + l * dx[k], nj = j + l * dy[k];
              if(0 <= ni && ni < 8 && 0 <= nj && nj < 8){
                if(table[ni][nj]){
                  return false;
                }
              }
            }
          }
        }
      }
    }

    return true;
  }
}
