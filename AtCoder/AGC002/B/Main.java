import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    x = new int[m]; y = new int[m];
    for(int i = 0; i < m; i++){
      x[i] = sc.nextInt() - 1;  y[i] = sc.nextInt() - 1;
    }

    int[] c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = 1;
    }

    boolean[] p = new boolean[n];
    p[0] = true;
    for(int i = 0; i < m; i++){
      if(p[x[i]]){
        p[y[i]] = true;
      }
      --c[x[i]];  ++c[y[i]];
      if(c[x[i]] == 0){
        p[x[i]] = false;
      }
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(p[i]){
        ++count;
      }
    }

    System.out.println(count);
  }
}
