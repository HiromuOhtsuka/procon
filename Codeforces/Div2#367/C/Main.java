import java.util.Scanner;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static final long INF = Long.MAX_VALUE / 2;
  static int n;
  static long[] c;
  static String[] s;

  public static void main(String[] args){
    new Main();
  }

  public Main(){
    n = nextInt();
    c = new long[n];
    for(int i = 0; i < n; i++){
      c[i] = nextLong();
    }
    s = new String[n];
    for(int i = 0; i < n; i++){
      s[i] = next();
    }

    String[] rs = new String[n];
    for(int i = 0; i < n; i++){
      rs[i] = new StringBuilder(s[i]).reverse().toString();
    }

    long[][] dp = new long[n][2];
    dp[0][1] = c[0];
    for(int i = 1; i < n; i++){
      long min = INF;
      if(s[i].compareTo(s[i - 1]) >= 0){
        min = Math.min(min, dp[i - 1][0]);
      }
      if(s[i].compareTo(rs[i - 1]) >= 0){
        min = Math.min(min, dp[i - 1][1]);
      }
      dp[i][0] = min;

      min = INF;
      if(rs[i].compareTo(s[i - 1]) >= 0){
        min = Math.min(min, dp[i - 1][0] + c[i]);
      }
      if(rs[i].compareTo(rs[i - 1]) >= 0){
        min = Math.min(min, dp[i - 1][1] + c[i]);
      }
      dp[i][1] = min;
    }

    long ans = Math.min(dp[n - 1][0], dp[n - 1][1]);
    if(ans != INF){
      System.out.println(ans);
    }
    else{
      System.out.println(-1);
    }
  }

  /* Input */
  private static final InputStream in = System.in;
  private static final PrintWriter out = new PrintWriter(System.out);
  private final byte[] buffer = new byte[2048];
  private int p = 0;
  private int buflen = 0;

  private boolean hasNextByte() {
    if (p < buflen)
      return true;
    p = 0;
    try {
      buflen = in.read(buffer);
    } catch (IOException e) {
      e.printStackTrace();
    }
    if (buflen <= 0)
      return false;
    return true;
  }

  public boolean hasNext() {
    while (hasNextByte() && !isPrint(buffer[p])) {
      p++;
    }
    return hasNextByte();
  }

  private boolean isPrint(int ch) {
    if (ch >= '!' && ch <= '~')
      return true;
    return false;
  }

  private int nextByte() {
    if (!hasNextByte())
      return -1;
    return buffer[p++];
  }

  public String next() {
    if (!hasNext())
      throw new NoSuchElementException();
    StringBuilder sb = new StringBuilder();
    int b = -1;
    while (isPrint((b = nextByte()))) {
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
