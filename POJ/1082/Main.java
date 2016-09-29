import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n;
  static boolean[][][] dp;

  public static void main(String[] args){
    dp = new boolean[2002][13][32];

    for(int y = 2001; y >= 1900; y--){
      for(int m = 12; m >= 1; m--){
        for(int d = day(y, m); d >= 1; d--){
          if(over(y, m, d)){
            continue;
          }
          int[] nd = nextDate(y, m, d);
          if(nd != null){
            dp[y][m][d] |= !dp[nd[0]][nd[1]][nd[2]];
          }
          int[] nm = nextMonth(y, m, d);
          if(nm != null){
            dp[y][m][d] |= !dp[nm[0]][nm[1]][nm[2]];
          }
        }
      }
    }

    FastScanner sc = new FastScanner();
    n = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      int y = sc.nextInt(), m = sc.nextInt(), d = sc.nextInt();
      if(dp[y][m][d]){
        sb.append("YES\n");
      }
      else{
        sb.append("NO\n");
      }
    }

    System.out.print(sb);
  }

  private static boolean isUrue(int y, int m){
    return y % 400 == 0 || y % 4 == 0 && y % 100 != 0;
  }

  private static int day(int y, int m){
    switch(m){
      case 4: case 6: case 9: case 11: return 30;
      case 2: return (isUrue(y, m) ? 29 : 28);
    }
    return 31;
  }

  private static boolean over(int y, int m, int d){
    return y > 2001 || d > day(y, m) ||
      y == 2001 && m >= 11 && d >= 4;
  }

  private static int[] nextDate(int y, int m, int d){
    if(d + 1 <= day(y, m)){
      if(!over(y, m, d + 1)){
        return new int[]{y, m, d + 1};
      }
    }
    else{
      if(m == 12){
        if(!over(y + 1, 1, 1)){
          return new int[]{y + 1, 1, 1};
        }
      }
      else{
        if(!over(y, m + 1, 1)){
          return new int[]{y, m + 1, 1};
        }
      }
    }
    return null;
  }

  private static int[] nextMonth(int y, int m, int d){
    if(m == 12){
      if(!over(y + 1, 1, d)){
        return new int[]{y + 1, 1, d};
      }
    }
    else{
      if(!over(y, m + 1, d)){
        return new int[]{y, m + 1, d};
      }
    }
    return null;
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
