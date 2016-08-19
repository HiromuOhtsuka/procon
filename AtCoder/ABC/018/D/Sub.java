import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Sub {
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
      for(int man = (1 << m) - 1; man >= 0; man--){
        if(Integer.bitCount(man) != q){
          continue;
        }
        max = Math.max(max, match(w, man));
      }
    }

    System.out.println(max);
  }

  private static int match(int w, int man){
    int sum = 0;
    for(int i = 0; i < n; i++){
      if((w & (1 << i)) != 0){
        int max = 0;
        for(int j = 0; j < G.get(i).size(); j++){
          Edge e = G.get(i).get(j);
          if((man & (1 << e.y)) != 0){
            sum += e.z;
          }
        }
      }
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
