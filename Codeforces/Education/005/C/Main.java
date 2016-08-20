import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n, m;
  static char[][] s;

  static final int[] dx = new int[]{0, -1, 0, 1}, dy = new int[]{-1, 0, 1, 0};
  static boolean[][] visited1, visited2;
  static int color;
  static int[][] values, colors;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    s = new char[n][m];
    for(int i = 0; i < n; i++){
      s[i] = sc.next().toCharArray();
    }

    visited1 = new boolean[n][m]; visited2 = new boolean[n][m];
    values = new int[n][m]; colors = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(s[i][j] != '*' && !visited1[i][j] && !visited2[i][j]){
          int v = dfs1(j, i);
          dfs2(j, i, v, ++color);
        }
      }
    }

    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(s[i][j] == '*'){
          int sum = 1;
          Set< Integer > kinds = new TreeSet< Integer >();
          for(int k = 0; k < 4; k++){
            int nx = j + dx[k], ny = i + dy[k];
            if(0 <= nx && nx < m && 0 <= ny && ny < n &&
              !kinds.contains(colors[ny][nx])){
              sum = (sum + values[ny][nx]) % 10;
              kinds.add(colors[ny][nx]);
            }
          }
          s[i][j] = (char)((sum % 10) + '0');
        }
      }
    }

    for(int i = 0; i < n; i++){
      System.out.println(s[i]);
    }
  }

  private static int dfs1(int x, int y){
    if(s[y][x] == '*' || visited1[y][x]){
      return 0;
    }
    visited1[y][x] = true;
    int sum = 0;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < m && 0 <= ny && ny < n){
        sum = (sum + dfs1(nx, ny)) % 10;
      }
    }
    return sum + 1;
  }

  private static void dfs2(int x, int y, int v, int color){
    if(s[y][x] == '*' || visited2[y][x]){
      return;
    }
    visited2[y][x] = true;
    colors[y][x] = color; values[y][x] = v;
    for(int i = 0; i < 4; i++){
      int nx = x + dx[i], ny = y + dy[i];
      if(0 <= nx && nx < m && 0 <= ny && ny < n){
        dfs2(nx, ny, v, color);
      }
    }
  }
}
