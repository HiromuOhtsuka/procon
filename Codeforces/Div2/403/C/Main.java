import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class Main{
  static int n;
  static List< List< Integer > > graph;
  static int[] color;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    graph = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      graph.add(new ArrayList< >());
    }
    for(int i = 0; i < n - 1; i++){
      int x = sc.nextInt() - 1, y = sc.nextInt() - 1;
      graph.get(x).add(y);
      graph.get(y).add(x);
    }

    color = new int[n];
    Arrays.fill(color, -1);

    dfs(0, 0, 0);

    int k = 0;
    for(int i = 0; i < n; i++){
      k = Math.max(k, color[i] + 1);
    }

    StringBuilder sb = new StringBuilder();
    sb.append(k + System.lineSeparator());
    for(int i = 0; i < n; i++){
      sb.append((color[i] + 1) + " ");
    }

    System.out.println(sb);
  }

  static void dfs(int v, int c, int p){
    color[v] = c;
    BitSet bs = new BitSet();
    bs.set(c);
    bs.set(color[p]);
    int nc = bs.nextClearBit(0);
    for(int w : graph.get(v)){
      if(w != p){
        nc = bs.nextClearBit(nc);
        dfs(w, nc, v);
        bs.set(nc);
      }
    }
  }
}
