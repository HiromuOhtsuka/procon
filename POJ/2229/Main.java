import java.util.Scanner;

public final class Main {
  public static final int MAX_N = 1000000;
  public static final int MAX_EXP = 20;   // log2(MAX_N) < 20
  private int N;
  private long[][] dp;

  public Main(){
    Scanner scan = new Scanner(System.in);

    dp = new long[MAX_EXP + 1][MAX_N + 1];
    while(scan.hasNextInt()){
      N = scan.nextInt();
      for(int i = 0; i <= MAX_EXP; i++){
        dp[i][0] = 1L;
      }
      dp[0][0] = 0L;
      for(int i = 1; i <= N; i++){
        dp[0][i] = 1L;
      }
      int i;
      for(i = 1; (1 << i) <= N; i++){
        for(int j = 1; j <= N; j++){
          if(j - (1 << i) >= 0){
            dp[i][j] = (dp[i][j - (1 << i)] + dp[i - 1][j]) % 1000000000L;
          }
          else{
            dp[i][j] = dp[i - 1][j] % 1000000000L;
          }
        }
      }

      System.out.println(dp[i - 1][N]);

      for(int k = 0; k <= MAX_EXP; k++){
        for(int j = 0; j <= N; j++){
          dp[k][j] = 0L;
        }
      }
    }
  }

  public static void main(String[] args){
    new Main();
  }
}
