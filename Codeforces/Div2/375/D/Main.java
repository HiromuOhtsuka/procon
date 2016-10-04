import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE;
  static int n, m, k;
  static char[][] table;

  static boolean[][] visited;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); k = sc.nextInt();
    table = new char[n][];
    for(int i = 0; i < n; i++){
      table[i] = sc.next().toCharArray();
    }

    visited = new boolean[n][m];
    for(int j = 0; j < m; j++){
      color(j, 0);  color(j, n - 1);
    }
    for(int i = 0; i < n; i++){
      color(0, i);  color(m - 1, i);
    }

    int[][] cmp = new int[n][m];
    int count = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        if(table[i][j] == '.' && !visited[i][j]){
          int c = dfs(j, i, false);
          cmp[i][j] = c;
          ++count;
        }
      }
    }

    for(int i = 0; i < n; i++){
      Arrays.fill(visited[i], false);
    }
    int sum = 0;
    for(int i = 0; i < count - k; i++){
      int min = INF, minx = -1, miny = -1;
      for(int y = 0; y < n; y++){
        for(int x = 0; x < m; x++){
          if(cmp[y][x] > 0 && min > cmp[y][x]){
            min = cmp[y][x];
            minx = x; miny = y;
          }
        }
      }
      sum += min; cmp[miny][minx] = 0;
      dfs(minx, miny, true);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(sum + System.lineSeparator());
    for(int i = 0; i < n; i++){
      sb.append(table[i]);
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  private static void color(int x, int y){
    if(!(0 <= x && x < m && 0 <= y && y < n) || 
      visited[y][x] || table[y][x] != '.'){
      return;
    }
    visited[y][x] = true;
    int[] dx = new int[]{0, -1, 0, 1},
      dy = new int[]{-1, 0, 1, 0};
    for(int i = 0; i < 4; i++){
      color(x + dx[i], y + dy[i]);
    }
  }

  private static int dfs(int x, int y, boolean draw){
    if(!(0 <= x && x < m && 0 <= y && y < n) || 
      visited[y][x] || table[y][x] != '.'){
      return 0;
    }

    visited[y][x] = true;
    if(draw){
      table[y][x] = '*';
    }

    int[] dx = new int[]{0, -1, 0, 1},
      dy = new int[]{-1, 0, 1, 0};
    int sum = 0;
    for(int i = 0; i < 4; i++){
      sum += dfs(x + dx[i], y + dy[i], draw);
    }

    return sum + 1;
  }
}
