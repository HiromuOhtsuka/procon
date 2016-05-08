import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    Map< String, Integer > map = new HashMap< String, Integer >();
    for(int i = 0; i < N; i++){
      String name = scan.next();
      int count = scan.nextInt();
      Integer value = map.get(name);
      if(value == null){
        map.put(name, count);
      }
      else{
        map.remove(name);
        map.put(name, value + count);
      }
    }
    Map.Entry[] a = 
      map.entrySet().toArray(new Map.Entry[map.size()] );
    Arrays.sort(a, new Comparator(){
        @Override
        public int compare(Object o1, Object o2){
          Map.Entry< String, Integer > e1 = (Map.Entry< String, Integer >) o1,
          e2 = (Map.Entry< String, Integer >) o2;
        String s1 = e1.getKey(), s2 = e2.getKey();
        if(s1.length() == s2.length()){
        return s1.compareTo(s2);
        }
        return s1.length() - s2.length();
        }
        }
        );

    for(int i = 0; i < a.length; i++){
      System.out.println(a[i].getKey() + " " + a[i].getValue());
    }

  }
}
