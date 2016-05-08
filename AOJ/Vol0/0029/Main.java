import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

public final class Main {
  private Map< String, Integer > map;
  private String maxlenword;

  public Main(){
    Scanner scan = new Scanner(System.in);
    map = new TreeMap< String, Integer >();
    maxlenword = "";

    while(scan.hasNext()){
      String word = scan.next();
      if(maxlenword.length() < word.length()){
        maxlenword = word;
      }
      if(!map.containsKey(word)){
        map.put(word, 1);
      }
      else{
        map.put(word, map.get(word) + 1);
      }
    }

    Set< Map.Entry< String, Integer > > set = map.entrySet();
    Iterator< Map.Entry< String, Integer > > it = set.iterator();
    String mode = "";
    int max = -1;
    while(it.hasNext()){
      Map.Entry< String, Integer > me = it.next();
      if(max < me.getValue()){
        max = me.getValue();
        mode = me.getKey();
      }
    }

    System.out.println(mode + " " + maxlenword);
  }

  public static void main(String[] args){
    new Main();
  }
}
