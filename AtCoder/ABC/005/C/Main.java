import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int t, n, m;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    t = sc.nextInt();
    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    m = sc.nextInt();
    b = new int[m];
    for(int i = 0; i < m; i++){
      b[i] = sc.nextInt();
    }

    if(m > n){
      System.out.println("no");
      return;
    }

    boolean[] check = new boolean[n];
    for(int i = 0; i < m; i++){
      int s = b[i] - t;
      int min = INF, minj = -1;
      for(int j = 0; j < n; j++){
        if(s <= a[j] && a[j] <= b[i] && !check[j]){
          if(min > a[j]){
            min = a[j]; minj = j;
          }
        }
      }
      if(minj == -1){
        System.out.println("no");
        return;
      }
      check[minj] = true;
    }

    System.out.println("yes");
  }
}
