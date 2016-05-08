import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int[] a = new int[N];
    Set< Integer > set = new HashSet< Integer >();
    for(int i = 0; i < N; i++){
      a[i] = scan.nextInt();
      set.add(a[i]);
    }

    int C = set.size();
    int s = 0, t = 0, best = N;
    Map< Integer, Integer > map = 
      new HashMap< Integer, Integer>();
    for(;;){
      while(t < N && map.size() < C){
        Integer i = map.get(a[t]);
        if(i == null){
          map.put(a[t++], 1);
        }
        else{
          map.put(a[t++], i + 1);
        }
      }
      if(map.size() < C){
        break;
      }
      Integer i = map.get(a[s]);
      best = Math.min(best, t - s);
      if(i == 1){
        map.remove(a[s++]);
      }
      else{
        map.put(a[s++], i - 1);
      }
    }

    System.out.println(best);
  }
}
