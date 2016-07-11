import java.util.Scanner;

public class Main {
  static int test, pa, pb, k, l;
  static double ppa, ppb;

  static boolean[][][] visited1, visited2;
  static double[][][] dp1, dp2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    test = sc.nextInt();
    for(int t = 0; t < test; t++){
      pa = sc.nextInt();  pb = sc.nextInt();
      k = sc.nextInt(); l = sc.nextInt();

      ppa = (double)pa / 100.0;
      ppb = (double)pb / 100.0;

      dp1 = new double[l + 1][l + 1][2];
      dp2 = new double[k + 1][k + 1][2];
      visited1 = new boolean[l + 1][l + 1][2];
      visited2 = new boolean[k + 1][k + 1][2];

      double p = 0.5 * match(0, 0, 0) + 0.5 * match(0, 0, 1);
/*
      System.out.println("g1:" + game(0, 0, 0));
      System.out.println("g2:" + game(0, 0, 1));
      System.out.println("m1:" + match(0, 0, 0));
      System.out.println("m2:" + match(0, 0, 1));
*/

      System.out.println(Math.round(p * 1000.0) / 10.0);
    }
  }

  private static double game(int a, int b, int f){
    if(a == l){
      return dp1[a][b][f] = 1;
    }
    if(b == l){
      return dp1[a][b][f] = 0;
    }

    if(visited1[a][b][f]){
      return dp1[a][b][f];
    }

    double p = 0;
    if(f == 0){
      p = ppa * game(a + 1, b, 0) +
        (1.0 - ppa) * game(a, b + 1, 1);
    }
    else{
      p = (1 - ppb) * game(a + 1, b, 0) +
        ppb * game(a, b + 1, 1);
    }
    visited1[a][b][f] = true;
    return dp1[a][b][f] = p;
  }

  private static double match(int a, int b, int f){
    if(a == k){
      return dp2[a][b][f] = 1;
    }
    if(b == k){
      return dp2[a][b][f] = 0;
    }

    if(visited2[a][b][f]){
      return dp2[a][b][f];
    }

    double p = 0;
    if(f == 0){
      p = game(0, 0, 0) * match(a + 1, b, 0) + (1 - game(0, 0, 0)) * match(a, b + 1, 1);
    }
    else{
      p = (1 - game(0, 0, 1)) * match(a, b + 1, 1) + game(0, 0, 1) * match(a + 1, b, 0);
    }
    visited2[a][b][f] = true;
    return dp2[a][b][f] = p;
  }
}
