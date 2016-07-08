import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {
  static int n;
  static int[] h, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    h = new int[n]; s = new int[n];

    PriorityQueue< Pair > pq = new PriorityQueue< Pair >();
    for(int i = 0; i < n; i++){
      h[i] = sc.nextInt();  s[i] = sc.nextInt();
      pq.offer(new Pair(h[i] + s[i], i));
    }

    long max = 0;
    for(int i = 0; i < n; i++){
      Pair p = pq.poll();
      max = Math.max(p.s - s[p.t], max);
      PriorityQueue< Pair > tmp = new PriorityQueue< Pair >();
      for(Pair pp : pq){
        tmp.offer(new Pair(pp.s + s[pp.t], pp.t));
      }
      pq = tmp;
    }

    System.out.println(max);
  }

  static class Pair implements Comparable< Pair > {
    long s;
    int t;

    Pair(long s, int t){
      this.s = s; this.t = t;
    }

    @Override
    public int compareTo(Pair p){
      return new Long(p.s).compareTo(s);
    }
  }
}
