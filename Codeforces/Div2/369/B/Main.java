import java.util.Scanner;

public class Main {
  static int n;
  static long[][] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        a[i][j] = sc.nextInt();
      }
    }

    if(n == 1){
      System.out.println(1);
      return;
    }

    long sum = -1;
    int ei = -1, ej = -1;
    for(int i = 0; i < n; i++){
      long s = 0;
      boolean flag = false;
      for(int j = 0; j < n; j++){
        if(a[i][j] == 0){
          flag = true;
          ei = i; ej = j;
          break;
        }
        s += a[i][j];
      }
      if(sum == -1 && !flag){
        sum = s;
      }
    }

    long ss = 0;
    for(int j = 0; j < n; j++){
      ss += a[ei][j];
    }

    long ans = sum - ss;
    if(ans <= 0){
      System.out.println(-1);
      return;
    }

    a[ei][ej] = ans;

    // row
    for(int i = 0; i < n; i++){
      long s = 0;
      for(int j = 0; j < n; j++){
        s += a[i][j];
      }
      if(sum != s){
        System.out.println(-1);
        return;
      }
    }

    // colmn
    for(int i = 0; i < n; i++){
      long s = 0;
      for(int j = 0; j < n; j++){
        s += a[j][i];
      }
      if(sum != s){
        System.out.println(-1);
        return;
      }
    }

    // diagonal
    ss = 0;
    for(int i = 0; i < n; i++){
      ss += a[i][i];
    }
    if(ss != sum){
      System.out.println(-1);
      return;
    }
    ss = 0;
    for(int i = 0; i < n; i++){
      ss += a[i][n - i - 1];
    }
    if(ss != sum){
      System.out.println(-1);
      return;
    }

    System.out.println(ans);
  }
}
