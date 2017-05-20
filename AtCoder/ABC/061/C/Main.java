import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static int[] a, b;
  static long k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextLong();
    a = new int[n];
    b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    Pair[] ba = new Pair[n];
    for(int i = 0; i < n; i++){
      ba[i] = new Pair(a[i], b[i]);
    }

    Arrays.sort(ba);

    int ans = -1;
    long sum = 0;
    for(int i = 0; i < n; i++){
      sum += (long)ba[i].c;
      if(sum >= k){
        ans = ba[i].v;
        break;
      }
    }

    System.out.println(ans);
  }

  static class Pair implements Comparable< Pair >{
    int v, c;

    Pair(int v, int c){
      this.v = v;
      this.c = c;
    }

    @Override
      public int compareTo(Pair p){
        if(v == p.v){
          return Integer.compare(c, p.c);
        }
        return Integer.compare(v, p.v);
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Pair)){
          return false;
        }
        Pair p = (Pair)obj;
        return v == p.v && c == p.c;
      }
  }
}
