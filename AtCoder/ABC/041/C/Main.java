import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static Pair[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new Pair[n];
    for(int i = 0; i < n; i++){
      int w = sc.nextInt();
      a[i] = new Pair(i, w);
    }

    Arrays.sort(a);

    for(int i = n - 1; i >= 0; i--){
      System.out.println(a[i].s + 1);
    }
  }

  static class Pair implements Comparable< Pair > {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }

    @Override
    public int compareTo(Pair p){
      return t - p.t;
    }
  }
}
