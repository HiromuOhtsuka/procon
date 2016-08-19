import java.util.Scanner;

public class Sub2 {
  static int n, m, d;
  static int[] a;

  static int[] order;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt();

    if(d > 1000){
      return;
    }

    a = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
    }

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

