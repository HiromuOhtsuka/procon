import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n;
  static int[] a, b;

  static List< List< Integer > > graph;

  static final boolean DEBUG = false;

  static int[] color;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n - 1];
    b = new int[n - 1];
    for(int i = 0; i < n - 1; i++){
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
    }

    graph = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList< >());
    }
    for(int i = 0; i < n - 1; i++){
      graph.get(a[i]).add(b[i]);
      graph.get(b[i]).add(a[i]);
    }

    int[] parent = new int[n];
    dfs(0, n - 1, -1, parent);

    List< Integer > path = new ArrayList< >();
    int v = n - 1;
    while(parent[v] != -1){
      path.add(v);
      if(DEBUG){
        System.out.println("v = " + v);
      }
      v = parent[v];
    }
    path.add(0);

    color = new int[n];
    int s = path.size() - 1, t = 0;
    for(int i = 0; i < path.size() / 2; i++){
      color[path.get(s)] = 1;
      if(s == t){
        continue;
      }
      color[path.get(t)] = 2;
      --s; ++t;
    }

    int count0 = dfsCount(0, -1, 1);
    int count1 = n - count0;
    if(count0 - 1 > count1 - 1){
      System.out.println("Fennec");
    }
    else{
      System.out.println("Snuke");
    }
  }

  static void dfs(int v, int t, int p, int[] parent){
    parent[v] = p;
    if(v == t){
      return;
    }
    for(int w : graph.get(v)){
      if(w != p){
        dfs(w, t, v, parent);
      }
    }
  }

  static int dfsCount(int v, int p, int c){
    int sum = 0;
    for(int w : graph.get(v)){
      if(w != p && (color[w] == 0 || color[w] == c)){
        sum += dfsCount(w, v, c);
      }
    }
    return sum + 1;
  }
}
