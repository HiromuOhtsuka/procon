import java.util.Scanner;

public class Main {
  static int n;
  static String s;

  static final int INF = Integer.MAX_VALUE / 2;
  static final String[] c = new String[]{"A", "B", "X", "Y"};

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    String[] command = new String[4 * 4];
    int sp = 0;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        command[sp++] = c[i] + c[j];
      }
    }

    int ans = INF;
    char[] str = s.toCharArray();
    for(int i = 0; i < sp; i++){
      for(int j = 0; j < sp; j++){
        String l = command[i], r = command[j];
        int[] dp = new int[n + 1];
        for(int k = 1; k <= n; k++){
          int min = INF;
          if(k - 2 >= 0 && ((str[k - 2] == l.charAt(0) &&  str[k - 1] == l.charAt(1)) ||
              (str[k - 2] == r.charAt(0) && str[k - 1] == r.charAt(1)))){
            min = Math.min(min, dp[k - 2] + 1);
          }
          min = Math.min(min, dp[k - 1] + 1);
          dp[k] = min;
        }
        ans = Math.min(ans, dp[n]);
      }
    }

    System.out.println(ans);
  }
}
