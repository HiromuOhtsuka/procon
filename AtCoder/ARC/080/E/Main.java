import java.util.Scanner;
import java.util.PriorityQueue;

public class Main{
  static int n;
  static int[] p;

  static final int MAX = 200000;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }

    int[] pos = new int[MAX + 1];
    for(int i = 0; i < n; i++){
      pos[p[i]] = i;
    }

    RangeMinimumTree re = new RangeMinimumTree(n);
    RangeMinimumTree ro = new RangeMinimumTree(n);
    for(int i = 0; i < n; i++){
      if(i % 2 == 0){
        re.update(i, p[i]);
      }
      else{
        ro.update(i, p[i]);
      }
    }

    int[] ans = new int[n];
    int sp = 0;

    PriorityQueue< Interval > pq = new PriorityQueue< >();
    pq.offer(new Interval(0, n, re.get(0, n)));

    while(sp < n){
      Interval interval = pq.poll();

      int p0 = interval.val;
      int p1 = ((pos[p0]  + 1) % 2 == 1 ? 
        ro.get(pos[p0] + 1, interval.b) : re.get(pos[p0] + 1, interval.b));

      if(DEBUG){
        System.out.println("p0 = " + p0);
        System.out.println("p1 = " + p1);
        System.out.println("pos[p0] = " + pos[p0]);
        System.out.println("pos[p1] = " + pos[p1]);
      }

      ans[sp++] = p0;
      ans[sp++] = p1;

      Interval i1 = new Interval(interval.a, pos[p0], 
          (interval.a % 2 == 0 ? 
           re.get(interval.a, pos[p0]) : ro.get(interval.a, pos[p0])));

      Interval i2 = new Interval(pos[p0] + 1, pos[p1], 
          ((pos[p0] + 1) % 2 == 0 ? 
           re.get(pos[p0] + 1, pos[p1]) : ro.get(pos[p0] + 1, pos[p1])));

      Interval i3 = new Interval(pos[p1] + 1, interval.b, 
          ((pos[p1] + 1) % 2 == 0 
           ? re.get(pos[p1] + 1, interval.b) : ro.get(pos[p1] + 1, interval.b)));

      pq.offer(i1);
      pq.offer(i2);
      pq.offer(i3);

      if(DEBUG){
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(ans[i] + " ");
    }

    System.out.println(sb);
  }

  static class Interval implements Comparable< Interval >{
    int a, b;
    int val;

    Interval(int a, int b, int val){
      this.a = a;
      this.b = b;
      this.val = val;
    }

    @Override
      public int compareTo(Interval i){
        return Integer.compare(val, i.val);
      }

    @Override
      public String toString(){
        return "a = " + a + ", b = " + b + ", val = " + val;
      }
  }
}

class RangeMinimumTree {
  static final int MAX = Integer.MAX_VALUE / 2;
  int n;
  int[] tree;

  RangeMinimumTree(int n){
    this.n = 1;
    while(this.n < n){
      this.n <<= 1;
    }
    this.tree = new int[this.n << 2];
    for(int i = 0; i < tree.length; i++){
      tree[i] = MAX;
    }
  }

  void update(int i, int x){
    i += n - 1;
    tree[i] = x;
    while(i > 0){
      i = (i - 1) / 2;
      tree[i] = Math.min(tree[2 * i + 1], tree[2 * i + 2]);
    }
  }

  int get(int a, int b){
    return get(a, b, 0, 0, n);
  }

  int get(int a, int b, int i, int l, int h){
    if(h <= a || b <= l){
      return MAX;
    }
    if(a <= l && h <= b){
      return tree[i];
    }
    int vl = get(a, b, 2 * i + 1, l, (l + h) / 2);
    int vr = get(a, b, 2 * i + 2, (l + h) / 2, h);
    return Math.min(vl, vr);
  }
}
