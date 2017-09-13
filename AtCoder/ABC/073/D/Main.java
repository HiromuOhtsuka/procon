import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m, r;
  static int[] p;
  static int[] a, b, c;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    r = sc.nextInt();
    p = new int[r];
    for(int i = 0; i < r; i++){
      p[i] = sc.nextInt() - 1;
    }
    a = new int[m];
    b = new int[m];
    c = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
      c[i] = sc.nextInt();
    }

    int[][] dist = new int[n][n];
    for(int i = 0; i < n; i++){
      Arrays.fill(dist[i], INF);
    }
    for(int i = 0; i < n; i++){
      dist[i][i] = 0;
    }
    for(int i = 0; i < m; i++){
      dist[a[i]][b[i]] = dist[b[i]][a[i]] = c[i];
    }
    for(int k = 0; k < n; k++){
      for(int i = 0; i < n; i++){
        for(int j = 0; j < n; j++){
          dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        }
      }
    }

    int ans = backTrack(0, new int[r], new boolean[r], dist);

    System.out.println(ans);
  }

  static int backTrack(int i, int[] perm, boolean[] used, int[][] dist){
    if(i == r){
      int sum = 0;
      for(int j = 0; j + 1 < r; j++){
        sum += dist[perm[j]][perm[j + 1]];
      }
      return sum;
    }
    int min = INF;
    for(int j = 0; j < r; j++){
      if(!used[j]){
        perm[i] = p[j];
        used[j] = true;
        min = Math.min(min, backTrack(i + 1, perm, used, dist));
        used[j] = false;
      }
    }
    return min;
  }
}
