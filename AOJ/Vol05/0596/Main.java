import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static int N, K;
  static int[][] G;
  static int[] sp;
  static int[] C, R;

  static final int INF = Integer.MAX_VALUE / 2;
  static int[] costs;
  static Queue< Integer > que;

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

    que = new LinkedList< Integer >();
    que.offer(0);
    costs[0] = 0;
    while(!que.isEmpty()){
      int v = que.poll();
      if(v == N - 1){
        continue;
      }
      dfs(v, 0, R[v], costs[v] + C[v], -1);
    }

    System.out.println(costs[N - 1]);
  }

  private static void dfs(int s, int d, int l, int c, int p){
    if(costs[s] > c){
      costs[s] = c;
      if(!que.contains(s)){
        que.offer(s);
      }
    }
    if(d == l){
      return;
    }
    for(int i = 0; i < sp[s]; i++){
      int nv = G[s][i];
      if(nv != p){
        dfs(nv, d + 1, l, c, s);
      }
    }
  }
}
