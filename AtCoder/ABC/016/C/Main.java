import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main {
  static int n, m;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
      G.get(a).add(new Edge(a, b)); G.get(b).add(new Edge(b, a));
    }

    int[] ans = new int[n];
    for(int v = 0; v < n; v++){
      Set< Integer > friends = new HashSet< Integer >();
      for(Edge e : G.get(v)){
        friends.add(e.w);
      }
      Set< Integer > ff = new HashSet< Integer >();
      for(Integer f : friends){
        for(Edge e : G.get(f)){
          if(e.w != v && !friends.contains(e.w)){
            ff.add(e.w);
          }
        }
      }
      ans[v] = ff.size();
    }

    for(int i = 0; i < n; i++){
      System.out.println(ans[i]);
    }
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }
}
