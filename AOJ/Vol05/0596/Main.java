import java.util.Scanner;
import java.util.PriorityQueue;

public class Main {
  static int N, K;
  static int[][] G;
  static int[] sp;
  static int[] C, R;

  static final int INF = Integer.MAX_VALUE / 2;
  static int[] costs;
  static PriorityQueue< Point > pq;
  static boolean end;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    N = sc.nextInt(); K = sc.nextInt();
    C = new int[N]; R = new int[N];
    for(int i = 0; i < N; i++){
      C[i] = sc.nextInt();  R[i] = sc.nextInt();
    }

    G = new int[N][N];  sp = new int[N];
    for(int i = 0; i < K; i++){
      int s = sc.nextInt(), t = sc.nextInt();
      --s; --t;
      G[s][sp[s]++] = t; G[t][sp[t]++] = s;
    }

    costs = new int[N];
    for(int i = 0; i < N; i++){
      costs[i] = INF;
    }

    pq = new PriorityQueue< Point >();
    costs[0] = 0;
    pq.offer(new Point(costs[0], 0));
    while(!pq.isEmpty() && !end){
      int v = pq.poll().v;
      dfs(v, 0, R[v], costs[v] + C[v], -1);
    }

    System.out.println(costs[N - 1]);
  }

  private static void dfs(int s, int d, int l, int c, int p){
    if(d == l){
      return;
    }
    for(int i = 0; i < sp[s]; i++){
      int nv = G[s][i];
      if(nv != p){
        if(costs[nv] > c){
          costs[nv] = c;
          pq.offer(new Point(costs[nv] + C[nv], nv));
        }
        if(nv == N - 1){
          end = true;
          return;
        }
        dfs(nv, d + 1, l, c, s);
      }
    }
  }

  static class Point implements Comparable< Point > {
    int c, v;

    Point(int c, int v){
      this.c = c; this.v = v;
    }

    @Override
    public int compareTo(Point p){
      return c - p.c;
    }
  }
}
