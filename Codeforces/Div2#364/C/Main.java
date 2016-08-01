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
    int s = 0, t = 0, count = 0, min = INF;
    Map< Character, Integer > map = new HashMap< Character, Integer >();
    while(s <= t){
      while(t < n && count != sum){
        if(map.containsKey(str[t])){
          int v = map.get(str[t]);
          map.put(str[t], v + 1);
        }
        else{
          map.put(str[t], 1);
          ++count;
        }
        ++t;
      }
      if(count == sum){
        min = Math.min(min, t - s);
      }
      if(map.get(str[s]) >= 2){
        int v = map.get(str[s]);
        map.put(str[s], v - 1);
      }
      else{
        map.remove(str[s]);
        --count;
      }
      ++s;
      if(s == t){
        break;
      }
    }

    System.out.println(min);
  }
}
