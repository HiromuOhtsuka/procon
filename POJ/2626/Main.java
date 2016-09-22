import java.util.Scanner;

public class Main {
  static int n;
  static int[][][] dp;
  static int[] h, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h = new int[1000]; b = new int[1000];
    while(sc.hasNext()){
      h[n] = sc.nextInt();  b[n] = sc.nextInt();
      ++n;
    }

    dp = new int[n + 1][16][16];
    for(int i = 1; i <= n; i++){
      for(int j = 0; j <= 15; j++){
        for(int k = 0; k <= 15; k++){
          int max = dp[i - 1][j][k];
          if(j - 1 >= 0){
            max = Math.max(max, dp[i - 1][j - 1][k] + h[i - 1]);
          }
          if(k - 1 >= 0){
            max = Math.max(max, dp[i - 1][j][k - 1] + b[i - 1]);
          }
          dp[i][j][k] = max;
        }
      }
    }

    System.out.println(dp[n][15][15]);
  }
}
