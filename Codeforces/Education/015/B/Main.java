import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int n;
  static long[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new long[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long[] tar = new long[34];
    for(int i = 0; i <= 33; i++){
      tar[i] = (1L << (long)i);
    }

    long count = 0;
    Map< Long, Long > map = new TreeMap< Long, Long >();
    for(int i = 0; i < n; i++){
      for(int j = 0; j < 34; j++){
        if(map.containsKey(tar[j] - a[i])){
          count += map.get(tar[j] - a[i]);
        }
      }
      if(!map.containsKey(a[i])){
        map.put(a[i], 1L);
      }
      else{
        long v = map.get(a[i]);
        map.put(a[i], v + 1L);
      }
    }

    System.out.println(count);
  }
}
