import java.util.Scanner;

public class Main {
  static int n, m, d;
  static int[] a;

  static int[] t;
  static boolean[] visited;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt(); d = sc.nextInt();
    a = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
    }

    int[] in = new int[n];
    for(int i = 0; i < n; i++){
      in[i] = i;
    }
    for(int i = 0; i < m; i++){
      int tmp = in[a[i]];
      in[a[i]] = in[a[i] + 1];
      in[a[i] + 1] = tmp;
    }
    int[] t = new int[n];
    for(int i = 0; i < n; i++){
      t[in[i]] = i;
    }

    for(int i = 0; i < n; i++){
      in[i] = i;
    }
    int x = 1, tmp = d;
    do{
      if((tmp & 1) != 0){
        for(int i = 0; i < n; i++){
          in[i] = t[in[i]];
        }
      }
      tmp >>= 1;
      x <<= 1;
      int[] w = new int[n];
      for(int i = 0; i < n; i++){
        w[i] = t[t[i]];
      }
      t = w;
    } while(tmp != 0);

    for(int i = 0; i < n; i++){
      System.out.println(in[i] + 1);
    }
  }
}

