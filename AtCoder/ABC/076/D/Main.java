import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] t, v;
  static final boolean DEBUG = true;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    t = new int[n];
    for(int i = 0; i < n; i++){
      t[i] = sc.nextInt();
    }
    v = new int[n];
    for(int i = 0; i < n; i++){
      v[i] = sc.nextInt();
    }

    int[] st = new int[n + 1];
    for(int i = 1; i <= n; i++){
      st[i] = st[i - 1] + t[i - 1];
    }

    double[] mv = new double[2 * st[n] + 1];
    for(int i = 0; i <= 2 * st[n]; i++){
      double k = 0.5 * i;
      double min = Math.min(k, (double)st[n] - k);
      for(int j = 0; j < n; j++){
        min = Math.min(min, f(j, st, k));
      }
      mv[i] = min;
    }

    double sum = 0;
    for(int i = 0; i < 2 * st[n]; i++){
      sum += 0.25 * (mv[i] + mv[i + 1]);
    }

    System.out.println(sum);
  }

  static double f(int i, int[] st, double k){
    if(k < st[i]){
      return (double)v[i] + ((double)st[i] - k);
    }
    else if(k > st[i + 1]){
      return (double)v[i] + (k - (double)st[i + 1]);
    }
    else{
      return v[i];
    }
  }
}
