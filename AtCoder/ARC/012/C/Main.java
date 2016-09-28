import java.util.Scanner;

public class Main {
  static char[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    table = new char[19][];
    for(int i = 0; i < 19; i++){
      table[i] = sc.next().toCharArray();
    }

    // check number
    int black = 0, white = 0;
    for(int i = 0; i < 19; i++){
      for(int j = 0; j < 19; j++){
        if(table[i][j] == 'o'){
          ++black;
        }
        else if(table[i][j] == 'x'){
          ++white;
        }
      }
    }

    if((white == 0 && black == 0) || (white == 0 && black == 1)){
      System.out.println("YES");
      return;
    }

    if(white > black || white + 1 < black){
      System.out.println("NO");
      return;
    }

    // check winner
    if(white < black){
      for(int i = 0; i < 19; i++){
        for(int j = 0; j < 19; j++){
          if(table[i][j] == 'o'){
            table[i][j] = '.';
            if(!(check('o') || check('x'))){
              System.out.println("YES");
              return;
            }
            table[i][j] = 'o';
          }
        }
      }
    }
    else{
      for(int i = 0; i < 19; i++){
        for(int j = 0; j < 19; j++){
          if(table[i][j] == 'x'){
            table[i][j] = '.';
            if(!(check('o') || check('x'))){
              System.out.println("YES");
              return;
            }
            table[i][j] = 'x';
          }
        }
      }
    }

    System.out.println("NO");
  }

  private static boolean check(char ch){
    for(int i = 0; i < 19; i++){
      for(int j = 0; j < 19; j++){
        if(table[i][j] == ch){
          if(winner(j, i, ch)){
            return true;
          }
        }
      }
    }
    return false;
  }

  private static boolean winner(int x, int y, char ch){
    // vertical
    int count = 1;
    // up
    int curx = x, cury = y - 1;
    while(cury >= 0 && table[cury][curx] == ch){
      ++count;  --cury;
    }
    // down
    curx = x; cury = y + 1;
    while(cury < 19 && table[cury][curx] == ch){
      ++count;  ++cury;
    }

    if(count >= 5){
      return true;
    }

    // horizonal
    count = 1;
    // left
    curx = x - 1; cury = y;
    while(curx >= 0 && table[cury][curx] == ch){
      ++count;  --curx;
    }
    // right
    curx = x + 1; cury = y;
    while(curx < 19 && table[cury][curx] == ch){
      ++count;  ++curx;
    }

    if(count >= 5){
      return true;
    }

    // left up to down right
    count = 1;
    // left up
    curx = x - 1; cury = y - 1;
    while(curx >= 0 && cury >= 0 && table[cury][curx] == ch){
      ++count;  --curx; --cury;
    }
    // right down
    curx = x + 1; cury = y + 1;
    while(curx < 19 && cury < 19 && table[cury][curx] == ch){
      ++count;  ++curx; ++cury;
    }

    if(count >= 5){
      return true;
    }

    // right up to down left
    count = 1;
    // right up
    curx = x + 1; cury = y - 1;
    while(curx < 19 && cury >= 0 && table[cury][curx] == ch){
      ++count;  ++curx; --cury;
    }
    // left down
    curx = x - 1; cury = y + 1;
    while(curx >= 0 && cury < 19 && table[cury][curx] == ch){
      ++count;  --curx; ++cury;
    }

    if(count >= 5){
      return true;
    }

    return false;
  }
}
