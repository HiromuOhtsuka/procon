import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
  static int n, m;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    a = new int[m];
    b = new int[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt() - 1;
      b[i] = sc.nextInt() - 1;
    }

    List< List< Integer > > graph = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList< >());
    }
    for(int i = 0; i < m; i++){
      graph.get(a[i]).add(b[i]);
      graph.get(b[i]).add(a[i]);
    }

    int count = 0;
    for(int i = 0; i < m; i++){
      graph.get(a[i]).remove(new Integer(b[i]));
      graph.get(b[i]).remove(new Integer(a[i]));
      if(connected(graph) >= 2){
        ++count;
      }
      graph.get(a[i]).add(b[i]);
      graph.get(b[i]).add(a[i]);
    }

    System.out.println(count);
  }

  static int connected(List< List< Integer > > graph){
    boolean[] visited = new boolean[n];
    int count = 0;
    for(int v = 0; v < n; v++){
      if(!visited[v]){
        dfs(graph, v, visited);
        ++count;
      }
    }
    return count;
  }

  static void dfs(List< List< Integer > > graph, 
      int v, boolean[] visited){
    visited[v] = true;
    for(int w: graph.get(v)){
      if(!visited[w]){
        dfs(graph, w, visited);
      }
    }
  }
}
