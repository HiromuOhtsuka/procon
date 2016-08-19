import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
  static int n, m;
  static int[][] f;
  static int count;

  static int[] l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    f = new int[n][m];
    l = new int[m]; r = new int[n];
    int count = 0;
    for(int i = 0; i < n; i++){
      String line = sc.next();
      for(int j = 0; j < m; j++){
        if(line.charAt(j) == '*'){
          f[i][j] = 1;
          ++count;
          ++l[j]; ++r[i];
        }
      }
    }

    if(count == 0){
          System.out.println("YES");
          System.out.println(1 + " " + 1);
          return;
    }

    for(int y = 0; y < n; y++){
      for(int x = 0; x < m; x++){
        if(f[y][x] == 1 && l[x] + r[y] - 1 == count){
          System.out.println("YES");
          System.out.println((y + 1) + " " + (x + 1));
          return;
        }
        else if(f[y][x] == 0 && l[x] + r[y] == count){
          System.out.println("YES");
          System.out.println((y + 1) + " " + (x + 1));
          return;
        }
      }
    }

    System.out.println("NO");
  }
}
