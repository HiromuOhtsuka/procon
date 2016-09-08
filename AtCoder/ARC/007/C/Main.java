import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static String s;

  static int b, n, allOne;
  static int[] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    n = s.length();

    char[] str = s.toCharArray();
    for(int i = 0; i < n; i++){
      if(str[i] == 'o'){
        b |= (1 << (n - i - 1));
      }
    }

    allOne = (1 << n) - 1;
    if(b == allOne){
      System.out.println(1);
      return;
    }

    dp = new int[1 << (n + 1)];
    int ans = opt(b);

    System.out.println(ans);
  }

  private static int opt(int bit){
    if(bit == allOne){
      return 1;
    }
    if(dp[bit] > 0){
      return dp[bit];
    }

    int sh = b;
    int min = INF;
    for(int i = 1; i <= n; i++){
      sh = rightShift(sh, n);
      int nb = bit | sh;
      if(nb == bit){
        continue;
      }
      min = Math.min(min, opt(nb) + 1);
    }

    return dp[bit] = min;
  }

  private static int rightShift(int bit, int n){
    int ret = bit >>> 1;
    ret |= ((bit & 1) != 0 ? (1 << (n - 1)) : 0);
    return ret;
  }
}
