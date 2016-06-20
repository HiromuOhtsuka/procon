import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m;
  static int[] l;
  static int[] rev, to;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    to = new int[n]; rev = new int[n];
    for(int i = 0; i < n; i++){
      rev[i] = to[i] = -1;
    }
    for(int i = 0; i < m; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1;
      to[v] = w;
      rev[w] = v;
    }
    l = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt() - 1;
    }

    List< Set< Integer > > childs = new ArrayList< Set< Integer > >();
    for(int i = 0; i < n; i++){
      childs.add(new TreeSet< Integer >());
    }

    for(int i = 0; i < n; i++){
      Set< Integer > s = childs.get(i);
      int v = to[i];
      while(v != -1){
        s.add(v);
        v = to[v];
      }
    }

    Set< Integer > leafs = new TreeSet< Integer >();
    for(int i = 0; i < n; i++){
      if(to[i] == -1){
        leafs.add(i);
      }
    }

    int[] list = new int[n];
    int sp = 0;
    boolean[] check = new boolean[n];
    for(Integer leaf : leafs){
      Set< Integer > child = null;
      int lf = leaf;
      while(lf != -1){
        if(check[l[lf]]){
          Set< Integer > tmp = childs.get(l[lf]);
          if(!tmp.contains(lf)){
            lf = rev[lf];
          }
          else{
            System.out.println(-1);
            return;
          }
        }
        else if(child == null || (!child.contains(l[lf]))){
          list[sp++] = l[lf];
          check[l[lf]] = true;
          child = childs.get(l[lf]);
          lf = rev[lf];
        }
        else{
          System.out.println(-1);
          return;
        }
      }
    }

    System.out.println(sp);
    for(int i = 0; i < sp; i++){
      System.out.println(list[i] + 1);
    }
  }
}
