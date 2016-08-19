import java.util.Scanner;

public class Sub3 {
  static int n, m, d;
  static int[] a;

  static int[] order;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt();
    a = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
    }

    if(d == 1){
      sub1();
    }
    else if(n <= 1000 && d <= 1000){
      sub2();
    }
    else if(n <= 8){
      sub3();
    }
  }

  private static void sub3(){
    int[] in = new int[n];
    for(int i = 0; i < n; i++){
      in[i] = i + 1;
    }

    order = new int[n];
    f(in);

    for(int i = 0; i < n; i++){
      in[i] = i + 1;
    }

    int N = 1;
    for(int i = 2; i <= n; i++){
      N *= i;
    }
    int cycle = 0;
    for(int i = 0; i < N; i++){
      int[] ret = g(in);
      in = ret;
      ++cycle;
      boolean init = true;
      for(int j = 0; j < n; j++){
        if(in[j] != j + 1){
          init = false;
          break;
        }
      }
      if(init){
        break;
      }
    }

    for(int i = 0; i < n; i++){
      in[i] = i + 1;
    }
    if(cycle != 1){
      for(int i = 0; i < d % cycle; i++){
        int[] ret = g(in);
        in = ret;
      }
    }

    for(int i = 0; i < n; i++){
      order[in[i] - 1] = i + 1;
    }

    for(int i = 0; i < n; i++){
      System.out.println(order[i]);
    }
  }

  private static void sub1(){
    int[] in = new int[n];
    for(int i = 0; i < n; i++){
      in[i] = i + 1;
    }

    order = new int[n];
    f(in);

    for(int i = 0; i < d - 1; i++){
      int[] ret = g(in);
      in = ret;
    }

    for(int i = 0; i < n; i++){
      order[in[i] - 1] = i + 1;
    }

    for(int i = 0; i < n; i++){
      System.out.println(order[i]);
    }
  }

  private static void sub2(){
    int[] in = new int[n];
    for(int i = 0; i < n; i++){
      in[i] = i + 1;
    }

    order = new int[n];
    f(in);

    for(int i = 0; i < d - 1; i++){
      int[] ret = g(in);
      in = ret;
    }

    for(int i = 0; i < n; i++){
      order[in[i] - 1] = i + 1;
    }

    for(int i = 0; i < n; i++){
      System.out.println(order[i]);
    }
  }


  private static void f(int[] in){
    for(int i = 0; i < m; i++){
      int tmp = in[a[i]];
      in[a[i]] = in[a[i] + 1];
      in[a[i] + 1] = tmp;
    }
    order = new int[n];
    for(int i = 0; i < n; i++){
      order[in[i] - 1] = i;
    }
  }

  private static int[] g(int[] in){
    int[] ret = new int[n];
    for(int i = 0; i < n; i++){
      ret[order[i]] = in[i];
    }
    return ret;
  }
}
