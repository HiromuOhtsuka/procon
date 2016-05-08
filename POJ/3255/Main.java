import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;

public final class Main {
  private int R, N;   // R : 辺の数, N : 頂点数
  private int[] first, second;
  private List[] G;

  private class Edge {
    private int to, cost;

    Edge(int to, int cost){
      this.to = to;
      this.cost = cost;
    }

    int getTo(){
      return to;
    }

    int getCost(){
      return cost;
    }
  }

  private class IntPair implements Comparable {
    private int first, second;

    IntPair(int first, int second){
      this.first = first;
      this.second = second;
    }

    int getFirst(){
      return first;
    }

    int getSecond(){
      return second;
    }

    @Override
    public int compareTo(Object obj){
      return this.first - ((IntPair)obj).first;
    }
  }

  public Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();   R = scan.nextInt();
    G = new List[N];
    for(int i = 0; i < N; i++){
      G[i] = new ArrayList< Edge >();
    }
    for(int i = 0; i < R; i++){
      int to, from, cost;
      from = scan.nextInt() - 1;  to = scan.nextInt() - 1;  cost = scan.nextInt();
      G[from].add(new Edge(to, cost));
      G[to].add(new Edge(from, cost));
    }

    first = new int[N];
    second = new int[N];

    search();

    System.out.println(second[N - 1]);
  }

  private void search(){
    final int INF = Integer.MAX_VALUE;
    for(int i = 0; i < N; i++){
      first[i] = second[i] = INF;
    }
    first[0] = 0;

    Queue pq = new PriorityQueue< IntPair >();
    pq.add(new IntPair(0, 0));
    while(!pq.isEmpty()){
      IntPair ip = (IntPair)pq.poll();
      int v = ip.getSecond(), d = ip.getFirst();
      if(d > second[v]){
        continue;
      }
      for(int i = 0; i < G[v].size(); i++){
        Edge e = (Edge)G[v].get(i);
        int nd = d + e.getCost();
        if(first[e.getTo()] > nd){
          int tmp = first[e.getTo()];
          first[e.getTo()] = nd;
          nd = tmp;
          pq.add(new IntPair(first[e.getTo()], e.getTo()));
        }
        if(first[e.getTo()] < nd && second[e.getTo()] > nd){
          second[e.getTo()] = nd;
          pq.add(new IntPair(second[e.getTo()], e.getTo()));
        }
      }
    }
  }

  public static void main(String[] args){
    new Main();
  }
}
