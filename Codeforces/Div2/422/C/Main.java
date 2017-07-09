import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class Main{
  static final int INF = Integer.MAX_VALUE;
  static int n, x;
  static int[] l, r, cost;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = sc.nextInt();
    l = new int[n];
    r = new int[n];
    cost = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt();
      r[i] = sc.nextInt();
      cost[i] = sc.nextInt();
    }

    Map< Integer, TreeSet< Block > > map = new HashMap< >();
    for(int i = 0; i < n; i++){
      int d = (r[i] - l[i] + 1);
      if(map.containsKey(d)){
        map.get(d).add(new Block(l[i], r[i], cost[i]));
      }
      else{
        TreeSet< Block > set = new TreeSet< >();
        set.add(new Block(l[i], r[i], cost[i]));
        map.put(d, set);
      }
    }

    for(TreeSet< Block > set : map.values()){
      List< Block > toRemoved = new ArrayList< >();
      int min = INF;
      for(Block b : set.descendingSet()){
        if(min < b.c){
          toRemoved.add(b);
        }
        min = Math.min(min, b.c);
      }
      for(Block b : toRemoved){
        set.remove(b);
      }
    }

    int min = INF;
    for(int i = 0; i < n; i++){
      int d = r[i] - l[i] + 1;
      if(!map.containsKey(x - d)){
        continue;
      }
      Block b = map.get(x - d).higher(new Block(r[i] + 1, 1, 1));
      if(b != null){
        min = Math.min(min, cost[i] + b.c);
      }
    }

    if(min != INF){
      System.out.println(min);
    }
    else{
      System.out.println(-1);
    }
  }

  static class Block implements Comparable< Block >{
    int l, r, c;

    Block(int l, int r, int c){
      this.l = l;
      this.r = r;
      this.c = c;
    }

    @Override
      public int compareTo(Block b){
        if(l == b.l){
          if(r == b.r){
            return Integer.compare(c, b.c);
          }
          return Integer.compare(r, b.r);
        }
        return Integer.compare(l, b.l);
      }

    @Override
      public boolean equals(Object obj){
        if(!(obj instanceof Block)){
          return false;
        }
        Block b = (Block)obj;
        return l == b.l && r == b.r && c == b.c;
      }

    @Override
      public int hashCode(){
        int seed = 1234;
        return seed ^ l ^ r ^ c;
      }
  }
}
