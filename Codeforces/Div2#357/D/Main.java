import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Main {
  static int n, m;
  static Set< Edge > edges;
  static Set< Integer > vertices;
  static Set< Integer > ll;
  static int[] l;
  static int[] rev;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    edges = new TreeSet< Edge >();
    rev = new int[n];
    for(int i = 0; i < n; i++){
      rev[i] = -1;
    }
    for(int i = 0; i < m; i++){
      int v = sc.nextInt() - 1, w = sc.nextInt() - 1;
      edges.add(new Edge(v, w));
      rev[w] = v;
    }
    l = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt();
    }

    vertices = new TreeSet< Integer >();
    for(int v = 0; v < n; v++){
      vertices.add(v);
    }
    ll = new TreeSet< Integer >();

    List< Set< Integer > > parents = new ArrayList< Set< Integer > >();
    for(int i = 0; i < n; i++){
      parents.add(new TreeSet< Integer >());
    }

    for(int i = 0; i < n; i++){
      Set< Integer > s = parents.get(i);
      int v = rev[i];
      while(v != -1){
        s.add(v);
        v = rev[v];
      }
    }

    int[] list = new int[n];
    int sp = 0;
    for(;;){
      int[] outd = new int[n];
      for(Edge e : edges){
        ++outd[e.v];
      }
      boolean flag = false;
      for(int i = 0; i < n; i++){
        if(vertices.contains(i) && outd[i] == 0 && !ll.contains(l[i])){
          Set< Integer > parent = parents.get(l[i] - 1);
          for(int j = 0; j < sp; j++){
            if(parent.contains(list[j] - 1)){
              System.out.println("-1");
              return;
            }
          }
          ll.add(l[i]);
          list[sp++] = l[i];
          edges.remove(new Edge(rev[i], i));
          vertices.remove(i);
          flag = true;
        }
      }
      if(!flag){
        break;
      }
    }

    System.out.println(sp);
    for(int i = 0; i < sp; i++){
      System.out.println(list[i]);
    }
  }

  static class Edge implements Comparable< Edge > {
    int v, w;

    Edge(int v, int w){
      this.v = v; this.w = w;
    }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Edge)){
          return false;
        }
        Edge e = (Edge)obj;
        return v == e.v && w == e.w;
      }

    @Override
      public int compareTo(Edge e){
        if(v == e.v){
          return w - e.w;
        }
        return v - e.v;
      }
  }
}
