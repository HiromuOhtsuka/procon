import java.util.Scanner;

public class Sub1 {
  static int n, m, d;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt();

    if(d != 1){
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

    f(in);

    int[] re = new int[n];
    for(int i = 0; i < n; i++){
      re[in[i] - 1] = i + 1;
    }

    for(int i = 0; i < n; i++){
      System.out.println(re[i]);
    }
  }


  private static void f(int[] in){
    for(int i = 0; i < m; i++){
      int tmp = in[a[i]];
      in[a[i]] = in[a[i] + 1];
      in[a[i] + 1] = tmp;
    }
  }
}
