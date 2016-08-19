import java.util.Scanner;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;

public class Main {
  static int n;
  static int[] a;
  static int[] parent;
  static TreeSet< Integer > tree;
  static Map< Integer, Integer > map;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    map = new HashMap< Integer, Integer >();
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      map.put(a[i], i);
    }

    tree = new TreeSet< Integer >();
    parent = new int[n];
    tree.add(a[0]);
    parent[0] = -1;
    map.put(0, -1);
    for(int i = 1; i < n; i++){
      Integer l = tree.lower(a[i]), h = tree.higher(a[i]);
      if(h == null){
        h = 0;
      }
      if(l == null){
        l = 0;
      }
      if(map.get(l) > map.get(h)){
        parent[i] = l;
      }
      else{
        parent[i] = h;
      }
      tree.add(a[i]);
    }

    for(int i = 1; i < n; i++){
      System.out.print(parent[i] + ((i == n - 1) ? "\n" : " "));
    }
  }
}
