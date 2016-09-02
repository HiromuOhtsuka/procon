import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next();

    Set< Character > set = new HashSet< Character >();
    for(int i = 0; i < n; i++){
      set.add(s.charAt(i));
    }

    char[] str = s.toCharArray();
    int sum = set.size();
    int s = 0, t = 0, min = INF;
    Map< Character, Integer > map = new HashMap< Character, Integer >();
    while(s <= t){
      while(t < n && map.size() != sum){
        map.merge(str[t], 1, (ov, v) -> {
          return ov + 1;
        });
        ++t;
      }
      if(map.size() == sum){
        min = Math.min(min, t - s);
      }
      if(map.get(str[s]) >= 2){
        int v = map.get(str[s]);
        map.put(str[s], v - 1);
      }
      else{
        map.remove(str[s]);
      }
      ++s;
      if(s == t){
        break;
      }
    }

    System.out.println(min);
  }
}
