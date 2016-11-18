import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n;
  static long[] a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n];  b = new long[n];  c = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
      c[i] = sc.nextInt();
    }

    Map< Long, TreeSet< Pair > > map = new TreeMap< Long, TreeSet< Pair > >();
    for(int i = 0; i < n; i++){
      long key = a[i] * b[i];
      if(map.containsKey(key)){
        TreeSet< Pair > val = map.get(key);
        val.add(new Pair(i, c[i]));
      }
      else{
        TreeSet< Pair > set = new TreeSet< Pair >();
        set.add(new Pair(i, c[i]));
        map.put(key, set);
      }
      key = a[i] * c[i];
      if(map.containsKey(key)){
        TreeSet< Pair > val = map.get(key);
        val.add(new Pair(i, b[i]));
      }
      else{
        TreeSet< Pair > set = new TreeSet< Pair >();
        set.add(new Pair(i, b[i]));
        map.put(key, set);
      }
      key = b[i] * c[i];
      if(map.containsKey(key)){
        TreeSet< Pair > val = map.get(key);
        val.add(new Pair(i, a[i]));
      }
      else{
        TreeSet< Pair > set = new TreeSet< Pair >();
        set.add(new Pair(i, a[i]));
        map.put(key, set);
      }
    }

    double max = -1;
    int i = -1, j = -1;
    for(Map.Entry< Long, TreeSet< Pair > > me : map.entrySet()){
      long key = me.getKey();
      TreeSet< Pair > val = me.getValue();
      if(val.size() == 1){
        Pair p = val.last();
        long[] xy = diff(a[p.i], b[p.i], c[p.i], p.h);
        double s = Math.min(Math.min(xy[0], xy[1]), p.h);
        if(max < s){
          max = s;  i = p.i;  j = -1;
        }
      }
      else{
        Pair p1 = val.last();
        Pair p2 = val.lower(p1);
        long[] xy = diff(a[p1.i], b[p1.i], c[p1.i], p1.h);
        double s = Math.min(Math.min(xy[0], xy[1]), (p1.h + p2.h));
        if(max < s){
          max = s;  i = p1.i; j = p2.i;
        }
      }
    }

    if(j != -1){
      System.out.println(2);
      System.out.println((i + 1) + " " + (j + 1));
    }
    else{
      System.out.println(1);
      System.out.println(i + 1);
    }
  }

  private static long[] diff(long p0, long p1, long p2, long p){
    if(p0 == p){
      return new long[]{p1, p2};
    }
    else if(p1 == p){
      return new long[]{p0, p2};
    }
    else if(p2 == p){
      return new long[]{p0, p1};
    }
    return null;
  }

  static class Pair implements Comparable< Pair > {
    int i;
    long h;

    Pair(int i, long h){
      this.i = i; this.h = h;
    }

    @Override
      public int compareTo(Pair p){
        int cmp = Long.compare(this.h, p.h);
        if(cmp == 0){
          return i - p.i;
        }
        return cmp;
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Pair)){
          return false;
        }
        Pair p = (Pair)obj;
        return i == p.i && h == p.h;
      }
  }
}
