import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Comparator;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    Map< String, Integer > map = 
      new TreeMap< String, Integer >(
          new Comparator< String >(){
          @Override
          public int compare(String s1, String s2){
          if(s1.length() == s2.length()){
          return s1.compareTo(s2);
          }
          return s1.length() - s2.length();
          };
          }
          );

    for(int i = 0; i < N; i++){
      String name = sc.next();
      int count = sc.nextInt();
      if(map.containsKey(name)){
        int v = map.get(name);
        map.remove(name);
        map.put(name, v + count);
      }
      else{
        map.put(name, count);
      }
    }

    for(Map.Entry< String, Integer > me : map.entrySet()){
      System.out.println(me.getKey() + " " +  me.getValue());
    }
  }
}
