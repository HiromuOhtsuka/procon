import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.Set;
import java.util.Iterator;

public final class Main {
  private int N;
  private Map<Integer, Integer> map;
  private int duplicates;

  public Main(){
    Scanner scan = new Scanner(System.in);
    map = new TreeMap< Integer, Integer >();
    N = scan.nextInt();
    for(int i = 0; i < N; i++){
      String str = scan.next();
      int n = tranceform(str);
      if(n == -1){
        continue;
      }
      if(map.containsKey(n)){
        int val = map.get(n);
        map.put(n, val + 1);
        ++duplicates;
      }
      else{
        map.put(n, 1);
      }
    }

    if(duplicates == 0){
      System.out.println("No duplicates.");
    }
    else{
      Iterator< Map.Entry< Integer, Integer > > it = map.entrySet().iterator();
      while(it.hasNext()){
        Map.Entry< Integer, Integer > me = it.next();
        int key = me.getKey(), val = me.getValue();
        if(val != 1){
          System.out.println(toExpressStr(key) + " " + val);
        }
      }
    }
  }

  private int tranceform(String str){
    if(str == null || "".equals(str)){
      return -1;
    }
    CharSequence cs = str.subSequence(0, str.length());
    int n = 0;
    for(int i = 0; i < cs.length(); i++){
      char ch = cs.charAt(i);
      if(ch == '-'){
        continue;
      }
      if('0' <= ch && ch <= '9'){
        n = n * 10 + (ch - '0');
      }
      else if('A' <= ch && ch <= 'R'){
        n = n * 10 + ((ch - 'A') / 3 + 2);
      }
      else{
        n = n * 10 + ((ch - 'A' - 1) / 3 + 2);
      }
    }
    return n;
  }

  private String toExpressStr(int n){
    char[] ret = new char[8];
    int sp = 7;
    while(sp > 3){
      int i = n % 10;
      ret[sp--] = (char)('0' + i);
      n /= 10;
    }
    ret[sp--] = '-';
    while(sp >= 0){
      int i = n % 10;
      ret[sp--] = (char)('0' + i);
      n /= 10;
    }
    return new String(ret);
  }

  public static void main(String[] args){
    new Main();
  }

}
