import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;

public class Main {
  static int n, q;
  static int[] t, x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); q = sc.nextInt();
    t = new int[q]; x = new int[q];
    for(int i = 0; i < q; i++){
      t[i] = sc.nextInt();  x[i] = sc.nextInt() - 1;
    }

    int r = 0, s = 0;
    int[] ans = new int[q];
    int[] nr = new int[q];
    Pair nt = (threes.size() >= 1 ? threes.get(0) : null);
    Map< Integer, Integer > count = new HashMap< Integer, Integer >();
    int sp = 1;
    for(int i = 0; i < q; i++){
      if(t[i] == 1){
        if(count.containsKey(x[i])){
          int v = count.get(x[i]);
          count.put(x[i], v + 1);
        }
        else{
          count.put(x[i], 1);
        }
        ++nr[++s];
        ++r;
        ans[i] = r;
      }
      else if(t[i] == 2){
        if(count.containsKey(x[i])){
          int v = count.get(x[i]);
          r -= v;
          count.remove(x[i]);
        }
        ans[i] = r;
      }
    }

    for(int i = 0; i < q; i++){
      System.out.println(ans[i]);
    }
  }

  static class Pair implements Comparable< Pair > {
    int s, t;

    Pair(int s, int t){
      this.s = s; this.t = t;
    }

    @Override
    public boolean equals(Object obj){
      if(!(obj instanceof Pair)){
        return false;
      }
      Pair p = (Pair)obj;
      return t == p.t;
    }

    @Override
    public int compareTo(Pair p){
      return t - p.t;
    }
  }
}
