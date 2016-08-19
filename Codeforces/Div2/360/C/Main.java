import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m;
  static int[] x;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    x = new int[n];
    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }
    for(int i = 0; i < m; i++){
      int u = sc.nextInt() - 1, v = sc.nextInt() - 1;
      G.get(u).add(new Edge(u, v));
      G.get(v).add(new Edge(v, u));
    }

    for(int v = 0; v < n; v++){
      if(x[v] == 0 && G.get(v).size() != 0){
        if(!dfs(v, 1)){
          System.out.println(-1);
          return;
        }
      }
    }

    int[] a = new int[n], b = new int[n];
    int sp1 = 0, sp2 = 0;
    for(int i = 0; i < n; i++){
      if(x[i] == 1){
        a[sp1++] = i + 1;
      }
      else if(x[i] == 2){
        b[sp2++] = i + 1;
      }
    }

    System.out.println(sp1);
    for(int i = 0; i < sp1; i++){
      System.out.print(a[i] + ((i == sp1 - 1) ? "\n" : " "));
    }
    System.out.println(sp2);
    for(int i = 0; i < sp2; i++){
      System.out.print(b[i] + ((i == sp2 - 1) ? "\n" : " "));
    }
  }

  private static boolean dfs(int v, int c){
    if(x[v] != 0 && x[v] != c){
      return false;
    }
    if(x[v] == c){
      return true;
    }
    x[v] = c;
    for(int i = 0; i < G.get(v).size(); i++){
      int w = G.get(v).get(i).w;
      if(!dfs(w, ((c == 1) ? 2 : 1))){
        return false;
      }
    }
    return true;
  }

  static class Edge {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }
  }

}
