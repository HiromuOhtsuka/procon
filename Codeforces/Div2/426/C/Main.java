import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;

public class Main{
  static int n;
  static int[] a, b;

  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      b[i] = sc.nextInt();
    }

    Set< Long > set = new TreeSet< >();
    for(long i = 1; i <= 1000000; i++){
      set.add(i * i * i);
    }
    Map< Long, Long > map = new TreeMap< >();
    for(long i = 1; i <= 1000000; i++){
      map.put(i * i * i, i);
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      if(a[i] == 1 && b[i] == 1){
        sb.append("Yes");
      }
      else if(judge(i, set, map)){
        sb.append("Yes");
      }
      else{
        sb.append("No");
      }
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  static boolean judge(int k, Set< Long > table, Map< Long, Long >map){
    long x = a[k];
    long y = b[k];
    if(!table.contains(x * y)){
      return false;
    }
    long c = map.get(x * y);
    return x % c == 0 && y % c == 0;
  }
}
