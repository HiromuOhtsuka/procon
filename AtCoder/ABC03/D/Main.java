import java.util.Scanner;

public class Main {
  static final long M = 1000000007;
  static int r, c, x, y, d, l;
  static long[][] pas;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); c = sc.nextInt();
    x = sc.nextInt(); y = sc.nextInt();
    d = sc.nextInt(); l = sc.nextInt();

    pas = new long[d + l + 1][d + l + 1];
    for(int i = 0; i <= d + l; i++){
      pas[i][0] = pas[i][i] = 1;
    }
    for(int i = 2; i <= d + l; i++){
      for(int j = 1; j <= d; j++){
        pas[i][j] = (pas[i - 1][j - 1] + pas[i - 1][j]) % M;
      }
    }

    long ans = (r - x + 1)* (c - y + 1) * pas[d + l][d] % M;

    System.out.println(ans);
  }
}
