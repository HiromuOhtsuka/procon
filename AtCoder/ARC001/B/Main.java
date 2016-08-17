import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int a, b;
  static int[] dp1, dp2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    dp1 = new int[81];
    Arrays.fill(dp1, INF);
    dp1[0] = 0;

    opt1(80);
    int min = INF;
    for(int j = -40; j <= 40; j++){
      int count = dp1[Math.abs(a - j)] + dp1[Math.abs(b - j)];
      min = Math.min(min, count);
    }

    System.out.println(min);
  }

  private static int opt1(int i){
    if(dp1[i] < INF){
      return dp1[i];
    }
    int min = INF;
    if(i - 1 >= 0){
      min = Math.min(min, opt1(i - 1) + 1);
    }
    if(i - 5 >= 0){
      min = Math.min(min, opt1(i - 5) + 1);
    }
    if(i - 10 >= 0){
      min = Math.min(min, opt1(i - 10) + 1);
    }
    return dp1[i] = min;
  }
}
