import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.List;
import java.util.ArrayList;

public class Main {
  static String str;

  static int n, sp, maxDepth;
  static List< List< String > > comments;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    str = sc.next();

    str = str + ",";
    n = str.length();

    comments = new ArrayList< >(n);
    for(int i = 0; i < n; i++){
      comments.add(new ArrayList< >());
    }

    while(sp < n){
      parse(0);
    }

    StringBuilder sb = new StringBuilder();
    sb.append((maxDepth + 1) + System.lineSeparator());
    for(int i = 0; i <= maxDepth; i++){
      for(String val : comments.get(i)){
        sb.append(val + " ");
      }
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }

  private static void parse(int depth){
    Token token = getToken();
    comments.get(depth).add(token.value);
    maxDepth = Math.max(maxDepth, depth);
    if(token.childNumber != 0){
      for(int i = 0; i < token.childNumber; i++){
        parse(depth + 1);
      }
    }
  }

  private static Token getToken(){
    StringBuilder value = new StringBuilder();
    while(sp < n && str.charAt(sp) != ','){
      value.append(str.charAt(sp));
      ++sp;
    }
    ++sp;

    int childNumber = 0;
    while(sp < n && str.charAt(sp) != ','){
      childNumber = 10 * childNumber + str.charAt(sp) - '0';
      ++sp;
    }
    ++sp;

    return new Token(value.toString(), childNumber);
  }

  static class Token {
    String value;
    int childNumber;

    Token(String value, int childNumber){
      this.value = value;
      this.childNumber = childNumber;
    }

    @Override
    public String toString(){
      return value + "," + childNumber;
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
