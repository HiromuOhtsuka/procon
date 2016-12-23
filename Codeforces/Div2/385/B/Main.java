import java.util.Scanner;

public class Main {
  static int n, m;
  static char[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    table = new char[n][m];
    for(int i = 0; i < n; i++){
      table[i] = sc.next().toCharArray();
    }

    int sx = -1, sy = -1;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(table[i][j] == 'X'){
          sy = i; sx = j;
          break;
        }
      }
      if(sx != -1 && sy != -1){
        break;
      }
    }

    int ex = m - 1;
    for(int j = sx; j < m; j++){
      if(table[sy][j] == '.'){
        ex = j - 1;
        break;
      }
    }
    int ey = n - 1;
    for(int i = sy; i < n; i++){
      if(table[i][sx] == '.'){
        ey = i - 1;
        break;
      }
    }

    boolean ok = true;
    // check filled
    for(int i = sy; i < ey; i++){
      for(int j = sx; j < ex; j++){
        if(table[i][j] != 'X'){
          ok = false;
          break;
        }
      }
    }
    // check left and right line
    for(int i = sy; i <= ey; i++){
      if(!isOver(i, sx - 1) && table[i][sx - 1] != '.'){
        ok = false;
        break;
      }
      if(!isOver(i, ex + 1) && table[i][ex + 1] != '.'){
        ok = false;
        break;
      }
    }
    // check down line
    for(int j = sx; j <= ex; j++){
      if(!isOver(ey + 1, j) && table[ey + 1][j] != '.'){
        ok = false;
        break;
      }
    }

    if(ok){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }

  private static boolean isOver(int i, int j){
    return !(0 <= i && i < n && 0 <= j && j < m);
  }
}
