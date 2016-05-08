import java.util.Scanner;

public class Main {
  static int A, B;
  static int[] a, b;
  static int[][] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    A = sc.nextInt(); B = sc.nextInt();
    a = new int[A]; b = new int[B];
    int sum = 0;
    for(int i = 0; i < A; i++){
      a[A - i - 1] = sc.nextInt();
      sum += a[A - i - 1];
    }
    for(int i = 0; i < B; i++){
      b[B - i - 1] = sc.nextInt();
      sum += b[B - i - 1];
    }

    dp = new int[A + 1][B + 1];
    for(int i = 0; i <= A; i++){
      for(int j = 0; j <= B; j++){
        dp[i][j] = -1;
      }
    }
    dp[0][0] = 0;

    int ans = opt(A, B, sum);

    System.out.println(ans);
  }

  static int opt(int i, int j, int s){
    if(dp[i][j] > 0){
      return dp[i][j];
    }
    int ret = 0;
    if(i - 1 >= 0){
      ret = Math.max(ret, s - opt(i - 1, j, s - a[i - 1]));
    }
    if(j - 1 >= 0){
      ret = Math.max(ret, s - opt(i, j - 1, s - b[j - 1]));
    }
    return dp[i][j] = ret;
  }
}
