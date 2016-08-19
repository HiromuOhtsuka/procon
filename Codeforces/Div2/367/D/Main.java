import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int q;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    q = sc.nextInt();

    Map< Integer, Integer > count = new TreeMap< Integer, Integer >();
    Node root = new Node(null, null, null);
    for(int i = 0; i < q; i++){
      String op = sc.next();
      if(op.equals("+")){
        int x = sc.nextInt();
        if(count.containsKey(x)){
          int c = count.get(x);
          count.put(x, c + 1);
        }
        else{
          count.put(x, 1);
          add(root, x);
        }
      }
      else if(op.equals("-")){
        int x = sc.nextInt();
        int c = count.get(x);
        if(c > 1){
          count.put(x, c - 1);
        }
        else{
          count.remove(x);
          remove(root, x);
        }
      }
      else{
        int x = sc.nextInt();
        int y = get(root, x);
        //System.out.println(Integer.toBinaryString(y));
        int ans = x ^ y;
        System.out.println(Math.max(x, ans));
      }
    }
/*
    System.out.println("trace:");
    trace(root, 0, 0);
*/
  }

  private static int get(Node r, int x){
    Node n = r;

    int ret = 0;
    for(int i = 31; i >= 0; i--){
      if((x & (1 << i)) != 0){
        if(n.l != null){
          n = n.l;
        }
        else if(n.r != null){
          n = n.r;
          ret |= (1 << i);
        }
      }
      else{
        if(n.r != null){
          n = n.r;
          ret |= (1 << i);
        }
        else if(n.l != null){
          n = n.l;
        }
      }
    }

    return ret;
  }

  private static void add(Node r, int x){
    Node n = r;
    for(int i = 31; i >= 0; i--){
      if((x & (1 << i)) != 0){
        if(n.r == null){
          n.r = new Node(null, null, n);
        }
        n = n.r;
      }
      else{
        if(n.l == null){
          n.l = new Node(null, null, n);
        }
        n = n.l;
      }
    }
  }
/*
  private static void trace(Node n, int v, int d){
    if(n == null){
      return;
    }

    if(n.l == null && n.r == null){
      System.out.println(v);
    }

    trace(n.l, v, d + 1);
    trace(n.r, v | (1 << d), d + 1);
  }
*/

  private static void remove(Node r, int x){
    Node n = r;
    for(int i = 31; i >= 0; i--){
      if((x & (1 << i)) != 0){
        n = n.r;
      }
      else{
        n = n.l;
      }
    }

    boolean flag = true;
    while(n.p != null){
      boolean rl = false, rr = false;
      if(flag && n.p.l == n){
        rl = true;
      }
      else if(flag && n.p.r == n){
        rr = true;
      }

      if(flag && n.p.l == null){
        flag = true;
      }
      else if(flag && n.p.r == null){
        flag = true;
      }
      else{
        flag = false;
      }

      if(rl){
        n.p.l = null;
      }
      if(rr){
        n.p.r = null;
      }

      n = n.p;
    }
  }

  static class Node {
    // l:0, r:1
    Node l, r, p;

    Node(Node l, Node r, Node p){
      this.l = l; this.r = r;
      this.p = p;
    }
  }

}
