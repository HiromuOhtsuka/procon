import java.util.Scanner;

public class Sub1 {
  static int n, d, x, y;
  static int count;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); d = sc.nextInt();
    x = sc.nextInt(); y = sc.nextInt();

    if(n > 8){
      return;
    }

    backTrack(0, 0, 0);

    double p = (double)count / (double)(1 << (2 * n));

    System.out.println(p);
  }

  private static void backTrack(int i, int nx, int ny){
    if(i == n){
      if(nx == x && ny == y){
        ++count;
      }
      return;
    }
    backTrack(i + 1, nx + d, ny);
    backTrack(i + 1, nx - d, ny);
    backTrack(i + 1, nx, ny + d);
    backTrack(i + 1, nx, ny - d);
  }
}
