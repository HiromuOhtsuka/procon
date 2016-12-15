import java.util.Scanner;

import java.util.Arrays;

public class Main {
  static int n;
  static int[] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt() - 1;
    }
    int[] deg = new int[n];
    Arrays.fill(deg, 1);
    for(int i = 0; i < n; i++){
      deg[c[i]]++;
    }

    for(int i = 0; i < n; i++){
      if(deg[i] == 1){
        System.out.println(-1);
        return;
      }
    }

    long t = 1;
    for(int s = 0; s < n; s++){
      int v = s, w = -1;
      long d = 0;
      do{
        w = v;
        v = c[v];
        ++d;
      }while(v != w && v != s);
      if(d % 2L == 0){
        d /= 2L;
      }
      if(v == s){
        t = (t * d) / gcd(t, d);
      }
    }

    System.out.println(t);
  }

  private static long gcd(long a, long b){
    if(a == 0L){
      return b;
    }
    return gcd(b % a, a);
  }
}
