import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int q;
  static Map< Edge, Long > t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    q = sc.nextInt();
    t = new TreeMap< Edge, Long >();
    for(int i = 0; i < q; i++){
      int op = sc.nextInt();
      long u = sc.nextLong(), v = sc.nextLong();
      switch(op){
        case 1 : long w = sc.nextLong(); increase(u, v, w); break;
        case 2 : long sum = fee(u, v); System.out.println(sum); break;
      }
    }
  }

  private static void increase(long u, long v, long w){
    long[] spath = path(v, u);

    for(int i = 0; i < spath.length - 1; i++){
      Edge e1 = new Edge(spath[i], spath[i + 1]), 
        e2 = new Edge(spath[i + 1], spath[i]);
      if(t.containsKey(e1) || t.containsKey(e2)){
        long tmp = 0;
        if(t.containsKey(e1)){
          tmp = Math.max(tmp, t.get(e1));
        }
        if(t.containsKey(e2)){
          tmp = Math.max(tmp, t.get(e2));
        }
        t.put(e1, tmp + w);
        t.put(e2, tmp + w);
      }
      else{
        t.put(e1, w);
        t.put(e2, w);
      }
    }
  }

  private static long fee(long u, long v){
    long[] spath = path(v, u);

    // debug
    /*
    for(int i = 0; i < spath.length; i++){
      System.out.print(" " + spath[i]);
    }
    System.out.println();
    */

    long sum = 0;
    for(int i = 0; i < spath.length - 1; i++){
      Edge e1 = new Edge(spath[i], spath[i + 1]),
      e2 = new Edge(spath[i + 1], spath[i]);
      long d = 0;
      if(t.containsKey(e1)){
        d = Math.max(d, t.get(e1));
      }
      if(t.containsKey(e2)){
        d = Math.max(d, t.get(e2));
      }
      sum += d;
    }

    return sum;
  }

  private static long[] path(long u, long v){
    long[] vpath = new long[64];
    int spv = 0;
    long tmp = v;
    while(tmp != 0L){
      vpath[spv++] = tmp;
      tmp /= 2L;
    }

    long[] upath = new long[64];
    int spu = 0;
    tmp = u;
    while(tmp != 0L){
      upath[spu++] = tmp;
      tmp /= 2L;
    }

    long l = -1;
    int li = -1, lj = -1;
    for(int i = 0; l == -1 && i < spv; i++){
      for(int j = 0; j < spu; j++){
        if(vpath[i] == upath[j]){
          l = vpath[i];
          li = i; lj = j;
          break;
        }
      }
    }

    long[] spath = new long[64 * 2];
    int sp = 0;
    for(int i = 0; i <= li; i++){
      spath[sp++] = vpath[i];
    }
    for(int i = lj - 1; i >= 0; i--){
      spath[sp++] = upath[i];
    }

    long[] ret = new long[sp];
    for(int i = 0; i < sp; i++){
      ret[i] = spath[i];
    }

    return ret;
  }

  static class Edge implements Comparable< Edge > {
    long u, v;

    Edge(long u, long v){
      this.u = u; this.v = v;
    }

    @Override
      public int compareTo(Edge e){
        if(equals(e)){
          return 0;
        }
        if(u == e.u){
          return new Long(v).compareTo(e.v);
        }
        return new Long(u).compareTo(e.u);
      }

    @Override
    public boolean equals(Object obj){
      if(!(obj instanceof Edge)){
        return false;
      }
      Edge e = (Edge)obj;
      return (u == e.u && v == e.v) || (u == e.v && v == e.u);
    }
  }
}
