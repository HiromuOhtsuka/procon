import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static double[] cards;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    cards = new double[277];
    for(int n = 1; n <= 276; n++){
      cards[n] = cards[n - 1] + (1 / (double)(n + 1));
    }

    StringBuilder sb = new StringBuilder();
    while(sc.hasNext()){
      double d = sc.nextDouble();

      if(d == 0){
        break;
      }

      for(int i = 1; i <= 276; i++){
        if(cards[i] >= d){
          sb.append(i + " card(s)\n");
          break;
        }
      }
    }

    System.out.print(sb);
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
