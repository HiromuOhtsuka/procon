import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static String a, b;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    a = sc.next();  b = sc.next();

    int s = 0;
    while(s + 1 < a.length() && a.charAt(s) == '0'){
      ++s;
    }
    String an = a.substring(s, a.length());

    s = 0;
    while(s + 1 < b.length() && b.charAt(s) == '0'){
      ++s;
    }
    String bn = b.substring(s, b.length());

    if(an.equals(bn)){
      System.out.println("=");
      return;
    }

    int len = Math.max(a.length(), b.length());

    StringBuilder sba = new StringBuilder(a), sbb = new StringBuilder(b);
    while(sba.length() < len){
      sba.insert(0, "0");
    }
    while(sbb.length() < len){
      sbb.insert(0, "0");
    }

    if(sba.toString().compareTo(sbb.toString()) < 0){
      System.out.println("<");
    }
    else{
      System.out.println(">");
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
