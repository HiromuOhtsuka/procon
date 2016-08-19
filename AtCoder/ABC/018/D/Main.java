import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
  static int n, m, p, q, r;
  static List< List< Edge > > G;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    p = sc.nextInt(); q = sc.nextInt();
    r = sc.nextInt();

    G = new ArrayList< List< Edge > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Edge >());
    }

    for(int i = 0; i < r; i++){
      int x = sc.nextInt() - 1, y = sc.nextInt() - 1,
        z = sc.nextInt();
      G.get(x).add(new Edge(x, y, z));
    }

    int max = 0;
    for(int w = (1 << n) - 1; w >= 0; w--){
      if(Integer.bitCount(w) != p){
        continue;
      }
      max = Math.max(max, match(w));
    }

    System.out.println(max);
  }

  private static int match(int w){
    int[] y = new int[m];
    for(int i = 0; i < n; i++){
      if((w & (1 << i)) != 0){
        for(int j = 0; j < G.get(i).size(); j++){
          Edge e = G.get(i).get(j);
          y[e.y] += e.z;
        }
      }
    }
    Arrays.sort(y);
    int count = 0, sum = 0;
    for(int i = m - 1; i >= 0; i--){
      if(count >= q){
        break;
      }
      ++count;
      sum += y[i];
    }

    return sum;
  }

  static class Edge {
    int x, y, z;

    Edge(int x, int y, int z){
      this.x = x; this.y = y; this.z = z;
    }
  }
}
