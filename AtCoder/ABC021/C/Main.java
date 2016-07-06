import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import java.util.Queue;
import java.util.LinkedList;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static final long MOD = 1000000007;
  static int n, a, b, m;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt() - 1; b = sc.nextInt() - 1;
    m = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
      G.get(x).add(new Edge(x, y));
      G.get(y).add(new Edge(y, x));
    }

    long[] p = new long[n];
    int[] d = new int[n];
    boolean[] visited = new boolean[n];
    Queue< Integer > que = new LinkedList< Integer >();
    que.offer(a);
    ++p[a];
    visited[a] = true;
    while(!que.isEmpty()){
      int v = que.poll();
      for(int i = 0; i < G.get(v).size(); i++){
        int w = G.get(v).get(i).w;
        if(!visited[w]){
          visited[w] = true;
          d[w] = d[v] + 1;
          int min = INF;
          for(int j = 0; j < G.get(w).size(); j++){
            int ww = G.get(w).get(j).w;
            if(visited[ww]){
              min = Math.min(min, d[ww]);
            }
          }
          for(int j = 0; j < G.get(w).size(); j++){
            int ww = G.get(w).get(j).w;
            if(visited[ww] && min == d[ww]){
              p[w] = (p[w] + p[ww]) % MOD;
            }
          }
          que.offer(w);
        }
      }
    }
/*
    System.out.println("d");
    for(int i = 0; i < n; i++){
      System.out.println(d[i]);
    }
    System.out.println("p");
    for(int i = 0; i < n; i++){
      System.out.println(p[i]);
    }
*/

    int min = INF;
    for(int i = 0; i < G.get(b).size(); i++){
      int w = G.get(b).get(i).w;
      if(visited[w]){
        min = Math.min(min, d[w]);
      }
    }

    long ans = 0;
    for(int i = 0; i < G.get(b).size(); i++){
      int w = G.get(b).get(i).w;
      if(min == d[w]){
        ans = (ans + p[w]) % MOD;
      }
    }

    System.out.println(ans);
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}
