import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static int n;
  static Map< String, Integer > map;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    map = new TreeMap< String, Integer >();
    for(int i = 0; i < n; i++){
      String s = sc.next();
      if(map.containsKey(s)){
        int v = map.get(s);
        map.put(s, v + 1);
      }
      else{
        map.put(s, 1);
      }
    }

    int max = 0;
    String maxs = "";
    for(Map.Entry< String, Integer > me : map.entrySet()){
      if(me.getValue() > max){
        max = me.getValue();
        maxs = me.getKey();
      }
    }

    System.out.println(maxs);
  }
}
