import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

import java.util.Arrays;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int MASK;
  static int n, m, y, z;
  static char[] c, b;
  static int[] p;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt(); m = sc.nextInt();
    y = sc.nextInt(); z = sc.nextInt();
    c = new char[m];  p = new int[m];
    for(int i = 0; i < m; i++){
      c[i] = sc.next().charAt(0);
      p[i] = sc.nextInt();
    }
    b = new char[n];
    String line = sc.next();
    for(int i = 0; i < n; i++){
      b[i] = line.charAt(i);
    }

    MASK = (1 << m) - 1;
    int[] d = new int[26];
    for(int i = 0; i < m; i++){
      d[c[i] - 'A'] = i;
    }

    int[][][] dp = new int[n + 1][m][(1 << m) + 1];

    for(int i = 0; i <= n; i++){
      for(int j = 0; j < m; j++){
        Arrays.fill(dp[i][j], -INF);
        dp[i][j][0] = 0;
      }
    }

    for(int i = 1; i <= n; i++){
      for(int j = 0; j < m; j++){
        for(int s = 0; s < (1 << m); s++){
          if((s & (1 << j)) == 0){
            continue;
          }
          else if(b[i - 1] == c[j]){
            int s1 = s, s2 = MASK & (s ^ (1 << j)), max = -INF;
            for(int k = 0; k < m; k++){
              if((s & (1 << k)) == 0){
                continue;
              }
              int score1 = dp[i - 1][k][s1] + p[j],
                score2 = dp[i - 1][k][s2] + p[j];
              if(dp[i - 1][k][s1] != -INF && k == j){
                score1 += y;
              }
              if(s2 != 0 && dp[i - 1][k][s2] != -INF && k == j){
                score2 += y;
              }
              if(s2 == (MASK & ~(1 << j))){
                score2 += z;
              }
              max = Math.max(max, Math.max(score1, score2));
            }
            dp[i][j][s] = max;
          }
          else{
            dp[i][j][s] = dp[i - 1][j][s];
          }
        }
      }
    }

    int ans = 0;
    for(int i = 0; i < m; i++){
      for(int s = 0; s < (1 << m); s++){
        ans = Math.max(ans, dp[n][i][s]);
      }
    }

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
