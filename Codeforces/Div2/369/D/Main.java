import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static final long MOD = 1_000_000_007;
  static int n;
  static int[] a;
  static List< List< Integer > > G;
  static List< List< Integer > > L;
  static int[] compo;
  static int c;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt() - 1;
    }

    G = new ArrayList< List< Integer > >(n);
    L = new ArrayList< List< Integer > >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< Integer >());
      L.add(new ArrayList< Integer >());
    }
    for(int v = 0; v < n; v++){
      G.get(v).add(a[v]);
      L.get(v).add(a[v]); L.get(a[v]).add(v);
    }

    compo = new int[n];
    Arrays.fill(compo, -1);
    for(int v = 0; v < n; v++){
      if(compo[v] == -1){
        compo[v] = c;
        dfs(v);
        ++c;
      }
    }

    int[] ind = new int[n];
    for(int v = 0; v < n; v++){
      for(int i = 0; i < G.get(v).size(); i++){
        ++ind[G.get(v).get(i)];
      }
    }

    int count = n;
    for(;;){
      boolean flag = false;
      for(int v = 0; v < n; v++){
        if(ind[v] == 0){
          --count;
          for(int i = 0; i < G.get(v).size(); i++){
            --ind[G.get(v).get(i)];
          }
          --ind[v];
          flag = true;
        }
      }
      if(!flag){
        break;
      }
    }

    int r = n - count;

    List< Set< Integer > > cList = new ArrayList< Set< Integer > >(c);
    for(int i = 0; i < c; i++){
      cList.add(new TreeSet< Integer >());
    }

    for(int v = 0; v < n; v++){
      if(ind[v] >= 1){
        cList.get(compo[v]).add(v);
      }
    }

    long ans = 1;
    for(Set< Integer > set : cList){
      if(set.size() >= 2){
        long tmp = (pow(2, set.size()) - 2) % MOD;
        ans = (ans * tmp) % MOD;
      }
    }

    ans = (ans * pow(2, r)) % MOD;

    System.out.println(ans);
  }

  private static long pow(long a, long b){
    long ret = 1;
    do{
      if((b & 1L) != 0){
        ret = (ret * a) % MOD;
      }
      a = (a * a) % MOD;
      b >>= 1L;
    }while(b != 0);
    return ret;
  }

  private static void dfs(int v){
    for(int i = 0; i < L.get(v).size(); i++){
      int w = L.get(v).get(i);
      if(compo[w] == -1){
        compo[w] = c;
        dfs(w);
      }
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
