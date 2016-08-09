import java.util.Scanner;

public class Sub {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int W = scan.nextInt(), H = scan.nextInt();
    int[] dp = new int[W];
    for(int j = 0; j < W; j++){
      dp[j] = 1;
    }
    for(int i = 1; i < H; i++){
      for(int j = 1; j < W; j++){
        dp[j] = (dp[j] + dp[j - 1]) % 1000000007;
      }
    }

    System.out.println(dp[W - 1]);
  }
}
