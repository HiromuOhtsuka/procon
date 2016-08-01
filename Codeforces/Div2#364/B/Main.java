import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main {
  static int n, m;
  static int[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    x = new int[m]; y = new int[m];
    for(int i = 0; i < m; i++){
      x[i] = sc.nextInt() - 1; y[i] = sc.nextInt() - 1;
    }

    long[] ans = new long[m];
    Set< Integer > setx = new HashSet< Integer >();
    Set< Integer > sety = new HashSet< Integer >();
    for(int i = 0; i < m; i++){
      sety.add(y[i]);
      setx.add(x[i]);
      ans[i] = (long)(n - setx.size()) * (n - sety.size());
    }

    for(int i = 0; i < m; i++){
      System.out.print(ans[i] + (i == m - 1 ? "\n" : " "));
    }
  }
}
