import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n, m;
  static List< List< Integer > > G;
  static int c;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    m = sc.nextInt();
    G = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      G.add(new ArrayList< >());
    }
    for(int i = 0; i < m; i++){
      int a = sc.nextInt() - 1;
      int b = sc.nextInt() - 1;
      G.get(a).add(b);
      G.get(b).add(a);
    }

    int[] color = new int[n];
    c = 0;
    for(int v = 0; v < n; v++){
      if(color[v] == 0){
        ++c;
        dfs(v, color);
      }
    }

    List< Set< Integer > > components =
      new ArrayList< >(c);
    for(int i = 0; i < c; i++){
      components.add(new HashSet< >());
    }
    for(int v = 0; v < n; v++){
      components.get(color[v] - 1).add(v);
    }

    long[] numOfEdges = new long[c];
    for(int v = 0; v < n; v++){
      numOfEdges[color[v] - 1] += (long)G.get(v).size();
    }
    for(int i = 0; i < c; i++){
      numOfEdges[i] /= 2;
    }

    for(int i = 0; i < c; i++){
      long size = components.get(i).size();
      if(numOfEdges[i] != size * (size - 1) / 2){
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");
  }

  private static void dfs(int v, int[] color){
    color[v] = c;
    for(int w : G.get(v)){
      if(color[w] == 0){
        dfs(w, color);
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
