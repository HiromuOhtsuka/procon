import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static int[] p;
  static String s;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }
    s = sc.next();

    char[] str = s.toCharArray();

    long ans = 0;
    for(int i = 0; i < n; i++){
      if(str[i] == 'B'){
        ans += p[i];
      }
    }

    // prefix
    long max = 0, sum = 0;
    int maxi = 0;
    long sum2 = 0;
    for(int i = 0; i < n; i++){
      if(str[i] == 'A'){
        sum += p[i];
      }
      else{
        sum -= p[i];
      }
      if(max < sum){
        max = sum;
        maxi = i;
      }
    }

    sum = 0;
    for(int i = 0; i <= maxi; i++){
      if(str[i] == 'A'){
        sum += p[i];
      }
    }
    for(int i = maxi + 1; i < n; i++){
      if(str[i] == 'B'){
        sum += p[i];
      }
    }

    ans = Math.max(sum, ans);

    // sufix
    max = sum = maxi = 0;
    for(int i = n - 1; i >= 0; i--){
      if(str[i] == 'A'){
        sum += p[i];
      }
      else{
        sum -= p[i];
      }
      if(max < sum){
        max = sum;
        maxi = i;
      }
    }

    sum = 0;
    for(int i = n - 1; i >= maxi; i--){
      if(str[i] == 'A'){
        sum += p[i];
      }
    }
    for(int i = maxi - 1; i >= 0; i--){
      if(str[i] == 'B'){
        sum += p[i];
      }
    }

    ans = Math.max(sum, ans);

    System.out.println(ans);
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
