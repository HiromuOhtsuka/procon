import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.TreeMap;

public class Main {
  static String ss;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    ss = sc.next();
    int n = ss.length();

    if(n < 26){
      System.out.println(-1);
      return;
    }

    char[] str = ss.toCharArray();
    Map< Character, Integer > map = new TreeMap< Character, Integer >();

    int s = 0, t = 0, count = 0;
    boolean nice = false;
    for(;;){
      while(t < n && (t - s) < 26){
        if(str[t] == '?'){
          ++count;
        }
        else{
          map.merge(str[t], 1, (ov, v) -> {
              return ov + 1;
              });
        }
        ++t;
      }

      if(t - s == 26){
        if(26 - map.size() == count){
          nice = true; break;
        }
      }
      else if(t - s < 26){
        break;
      }

      if(str[s] == '?'){
        --count;
      }
      else if(map.get(str[s]) == 1){
        map.remove(str[s]);
      }
      else{
        int c = map.get(str[s]);
        map.put(str[s], c - 1);
      }

      ++s;
    }

    if(nice){
      for(int i = s; i < t; i++){
        if(str[i] == '?'){
          for(char ch =  'A'; ch <= 'Z'; ch++){
            if(!map.containsKey(ch)){
              str[i] = ch;  map.put(ch, 1);
              break;
            }
          }
        }
      }

      for(int i = 0; i < n; i++){
        if(str[i] == '?'){
          str[i] = 'A';
        }
      }

      System.out.println(str);
    }
    else{
      System.out.println(-1);
    }
  }
}

class FastScanner {
  private static final InputStream in = System.in;
  private static final PrintWriter out = new PrintWriter(System.out);
  private final byte[] buffer = new byte[2048];
  private int p = 0;
  private int buflen = 0;

  public FastScanner(){
  }

  private boolean hasNextByte() {
    if(p < buflen){
      return true;
    }
    p = 0;
    try{
      buflen = in.read(buffer);
    }catch (IOException e) {
      e.printStackTrace();
    }
    if(buflen <= 0){
      return false;
    }
    return true;
  }

  public boolean hasNext() {
    while(hasNextByte() && !isPrint(buffer[p])){
      p++;
    }
    return hasNextByte();
  }

  private boolean isPrint(int ch) {
    if(ch >= '!' && ch <= '~'){
      return true;
    }
    return false;
  }

  private int nextByte() {
    if(!hasNextByte()){
      return -1;
    }
    return buffer[p++];
  }

  public String next() {
    if(!hasNext()){
      throw new NoSuchElementException();
    }
    StringBuilder sb = new StringBuilder();
    int b = -1;
    while(isPrint((b = nextByte()))){
      sb.appendCodePoint(b);
    }
    return sb.toString();
  }

  public int nextInt() {
    return Integer.parseInt(next());
  }

  public long nextLong() {
    return Long.parseLong(next());
  }

  public double nextDouble() {
    return Double.parseDouble(next());
  }
}
