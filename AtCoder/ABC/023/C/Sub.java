import java.util.Scanner;

public class Sub {
  static int r, c, k, n;
  static int[] rs, cs;
  static boolean[][] table;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); c = sc.nextInt(); k = sc.nextInt();
    n = sc.nextInt();

    if(r > 50 || c > 50){
      return;
    }

    rs = new int[r];  cs = new int[c];
    table = new boolean[r][c];
    for(int i = 0; i < n; i++){
      int y = sc.nextInt() - 1, x = sc.nextInt() - 1;
      ++rs[y];  ++cs[x];
      table[y][x] = true;
    }

    int count = 0;
    for(int y = 0; y < r; y++){
      for(int x = 0; x < c; x++){
        if(rs[y] + cs[x] - ((table[y][x] ? 1 : 0)) == k){
          ++count;
        }
      }
    }

    System.out.println(count);
  }
}
