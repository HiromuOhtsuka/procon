import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
  static int n, m;
  static List< List< Integer > > graph;

  static int count;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    graph = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList< >());
    }
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1, b = sc.nextInt() - 1;
      graph.get(a).add(b);
      graph.get(b).add(a);
    }

    count = 0;
    backTrack(0, 0, new boolean[n]);

    System.out.println(count);
  }

  static void backTrack(int i, int v, boolean[] visited){
    if(i == n - 1){
      ++count;
      return;
    }
    visited[v] = true;
    for(int w : graph.get(v)){
      if(!visited[w]){
        backTrack(i + 1, w, visited);
      }
    }
    visited[v] = false;
  }
}
