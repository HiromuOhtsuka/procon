import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n;
  static String[] w;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    w = new String[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.next();
    }

    String[] ans = new String[n];
    int count = 0;
    for(int i = 0; i < n; i++){
      String tmp = pipe(w[i]);
      if(!"".equals(tmp)){
        ans[count++] = tmp;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < count; i++){
      sb.append(ans[i]);
      if(i != count - 1){
        sb.append(" ");
      }
    }

    System.out.println(sb);
  }

  private static String pipe(String s){
    StringBuilder sb = new StringBuilder();
    s = s.toLowerCase();
    for(int i = 0; i < s.length(); i++){
      switch(s.charAt(i)){
        case 'b': case 'c': sb.append(1); break;
        case 'd': case 'w': sb.append(2); break;
        case 't': case 'j': sb.append(3); break;
        case 'f': case 'q': sb.append(4); break;
        case 'l': case 'v': sb.append(5); break;
        case 's': case 'x': sb.append(6); break;
        case 'p': case 'm': sb.append(7); break;
        case 'h': case 'k': sb.append(8); break;
        case 'n': case 'g': sb.append(9); break;
        case 'z': case 'r': sb.append(0); break;
      }
    }
    return sb.toString();
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
