import java.util.Scanner;

public class Main {
  static int x, y;
  static String w;
  static char[][] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt() - 1; y = sc.nextInt() - 1; w = sc.next();
    c = new char[9][];
    for(int i = 0; i < 9; i++){
      c[i] = sc.next().toCharArray();
    }

    int dx = 0, dy = 0;
    if(w.charAt(0) == 'R'){
      dx = 1;
    }
    else if(w.charAt(0) == 'L'){
      dx = -1;
    }
    else if(w.charAt(0) == 'D'){
      dy = 1;
    }
    else{
      dy = -1;
    }
    if(w.length() == 2){
      if(w.charAt(1) == 'U'){
        dy = -1;
      }
      else if(w.charAt(1) == 'D'){
        dy = 1;
      }
    }

    char[] ans = new char[4];
    int px = x, py = y;
    ans[0] = c[y][x];
    for(int i = 1; i < 4; i++){
      int nx = px + dx, ny = py + dy;
      if(0 <= nx && nx < 9 && 0 <= ny && ny < 9){
        ans[i] = c[ny][nx];
      }
      else{
        if(ny < 0 || ny >= 9){
          dy = -dy;
        }
        if(nx < 0 || nx >= 9){
          dx = -dx;
        }
        nx = px + dx; ny = py + dy;
        ans[i] = c[ny][nx];
      }
      px = nx;  py = ny;
    }

    System.out.println(ans);
  }
}
