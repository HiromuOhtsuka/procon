import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    boolean[] isPrime = new boolean[2001];
    Arrays.fill(isPrime, true);
    isPrime[1] = false;
    for(int i = 2; i < isPrime.length; i++){
      if(isPrime[i]){
        for(int j = 2; j * i < isPrime.length; j++){
          isPrime[i * j] = false;
        }
      }
    }

    int[] dp = new int[2001];
    Arrays.fill(dp, INF);
    dp[0] = 0; dp[1] = 1;  dp[2] = 1;
    for(int i = 1; i < dp.length; i++){
      if(isPrime(i)){
        dp[i] = 1;
        continue;
      }
      for(int j = i; j >= 0; j--){
        if(i - j >= 2 && isPrime[j]){
          dp[i] = Math.min(dp[i - j] + 1, dp[i]);
        }
      }
    }

    int ans = n / 2;
    if(isPrime(n)){
      ans = 1;
    }
    else{
      for(int d = n; n - d < dp.length && d >= 2; d--){
        if(n - d >= 2 && n - d < dp.length && isPrime(d)){
          ans = Math.min(ans, dp[n - d] + 1);
        }
      }
    }

    System.out.println(ans);
  }

  private static boolean isPrime(int i){
    for(int j = 2; j * j <= i; j++){
      if(i % j == 0){
        return false;
      }
    }
    return true;
  }
}
