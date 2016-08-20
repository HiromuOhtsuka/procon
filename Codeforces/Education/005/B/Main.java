import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n, m;
  static int[][] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    c = new int[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        c[i][j] = sc.nextInt();
      }
    }

    int max = 1;
    for(int i = 0; i < n; i++){
      int min = INF;
      for(int j = 0; j < m; j++){
        min = Math.min(min, c[i][j]);
      }
      max = Math.max(max, min);
    }

    System.out.println(max);
  }
}
