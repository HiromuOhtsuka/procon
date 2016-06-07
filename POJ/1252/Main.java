import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int[] c;
  static int[] dp1; // お釣りなし
  static int[][] dp2; // お釣りあり

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int test = sc.nextInt();
    for(int t = 0; t < test; t++){
      c = new int[6];
      for(int i = 0; i < 6; i++){
        c[i] = sc.nextInt();
      }

      dp1 = new int[1001];
      for(int i = 1; i < dp1.length; i++){
        int min = INF;
        for(int j = 0; j < 6; j++){
          if(i - c[j] >= 0){
            min = Math.min(min, dp1[i - c[j]] + 1);
          }
        }
        dp1[i] = min;
      }

      dp2 = new int[101][1001];
      for(int i = 0; i < dp2.length; i++){
        for(int j = 0; j < dp2[i].length; j++){
          dp2[i][j] = INF;
        }
      }

      for(int i = 0; i < dp2.length; i++){
        for(int j = 0; j < dp2[i].length; j++){
          if(j - i >= 0){
            dp2[i][j] = Math.min(dp2[i][j], dp1[j - i] + dp1[j]);
          }
        }
      }

      int max = 0;
      double sum = 0;
      for(int i = 0; i < dp2.length; i++){
        int min = INF;
        for(int j = 0; j < dp2[i].length; j++){
          if(dp2[i][j] != INF){
            min = Math.min(min, dp2[i][j]);
          }
        }
        sum += min;
        max = Math.max(max, min);
      }

      double ave = sum / 100.0;
      System.out.printf("%.2f %d\n", ave, max);
    }
  }
}
