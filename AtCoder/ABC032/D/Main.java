import java.util.Scanner;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n, W;
  static int[] v, w;

  static boolean[] t;
  static long[][] dp1;
  static long[][] dp2;

  static long best;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); W = sc.nextInt();
    v = new int[n]; w = new int[n];
    int c = 1;
    for(int i = 0; i < n; i++){
      v[i] = sc.nextInt();  w[i] = sc.nextInt();
      if(w[i] > 1000){
        c = 3;
      }
      if(v[i] > 1000){
        c = 2;
      }
    }

    if(n <= 30){
      c = 1;
    }

    t = new boolean[n];
    switch(c){
      case 1 : solve1(0, 0, 0); break;
      case 2 : solve2(); break;
      case 3 : solve3(); break;
    }

    System.out.println(best);
  }

  private static void solve1(int i, long ww, long value){
    if(ww > W){
      return;
    }

    if(i == n){
      if(best < value){
        best = value;
      }
      return;
    }

    t[i] = true;
    solve1(i + 1, ww + w[i], value + v[i]);
    t[i] = false;
    solve1(i + 1, ww, value);
  }

  private static void solve2(){
    dp1 = new long[n + 1][200 * 1000 + 1];

    if(w[0] <= W){
      for(int j = w[0]; j <= W; j++){
        dp1[1][j] = v[0];
      }
    }
    for(int i = 2; i <= n; i++){
      for(int j = 1; j <= W; j++){
        if(j - w[i - 1] >= 0){
          dp1[i][j] = Math.max(dp1[i - 1][j], 
              dp1[i - 1][j - w[i - 1]] + v[i - 1]);
        }
        else{
          dp1[i][j] = dp1[i - 1][j];
        }
      }
    }

    best = dp1[n][W];
  }

  private static void solve3(){
    dp2 = new long[n + 1][200 * 1000 + 1];

    for(int j = 0; j < 200 * 1000 + 1; j++){
      dp2[1][j] = INF;
    }

    dp2[1][0] = 0;
    for(int i = 2; i <= n; i++){
      for(int j = 0; j <= 200 * 1000; j++){
        if(j - v[i - 1] >= 0){
          dp2[i][j] = Math.min(dp2[i - 1][j], 
              dp2[i - 1][j - v[i - 1]] + w[i - 1]);
        }
        else{
          dp2[i][j] = dp2[i - 1][j];
        }
      }
    }

    best = 0;
    for(int i = 200 * 1000; i >= 0; i--){
      if(dp2[n][i] <= W){
        best = i;
        break;
      }
    }
  }
}
