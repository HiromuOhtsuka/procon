import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.HashSet;

public class Main{
  static char[] t, p;
  static int[] perm;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    t = sc.next().toCharArray();
    p = sc.next().toCharArray();
    int n = t.length;
    perm = new int[n];
    for(int i = 0; i < n; i++){
      perm[i] = sc.nextInt() - 1;
    }

    int low = 0, high = n + 1;
    while(high - low > 1){
      int mid = (high + low) / 2;
      if(f(mid)){
        low = mid;
      }
      else{
        high = mid;
      }
    }

    System.out.println(low);
  }

  static boolean f(int k){
    int n = t.length;

    if(n - k < p.length){
      return false;
    }

    boolean[] flag = new boolean[n];
    for(int i = 0; i < k; i++){
      flag[perm[i]] = true;
    }

    Map< Character, TreeSet< Integer > > map = new HashMap< >();
    for(int i = 0; i < n; i++){
      if(flag[i]){
        continue;
      }
      if(!map.containsKey(t[i])){
        TreeSet< Integer > set = new TreeSet< >();
        set.add(i);
        map.put(t[i], set);
      }
      else{
        map.get(t[i]).add(i);
      }
    }

    int l = -1;
    for(int i = 0; i < p.length; i++){
      TreeSet< Integer > ts = map.get(p[i]);
      if(ts == null || ts.isEmpty()){
        return false;
      }
      Integer h = ts.higher(l);
      if(h == null){
        return false;
      }
      l = h;
    }

    return true;
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
