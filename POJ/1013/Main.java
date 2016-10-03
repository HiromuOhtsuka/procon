import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.NoSuchElementException;

public class Main {
  static int n;
  static String[][] l, r, result;

  public static void main(String[] args){
    FastScanner sc = new FastScanner();

    n = sc.nextInt();
    l = new String[n][3];  r = new String[n][3];  result = new String[n][3];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < 3; j++){
        l[i][j] = sc.next(); r[i][j] = sc.next(); result[i][j] = sc.next();
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      int notEven = -1;
      for(int j = 0; j < 3; j++){
        if(!"even".equals(result[i][j])){
          notEven = j;  break;
        }
      }

      for(char ch = 'A'; ch <= 'L'; ch++){
        boolean flag = true, isLight = true, check = false;
        if(l[i][notEven].indexOf(ch) >= 0 &&
            r[i][notEven].indexOf(ch) == -1){
          if("up".equals(result[i][notEven])){
            isLight = false;
          }
          check = true;
        }
        else if(l[i][notEven].indexOf(ch) == -1 &&
            r[i][notEven].indexOf(ch) >= 0){
          if("down".equals(result[i][notEven])){
            isLight = false;
          }
          check = true;
        }

        if(!check){
          continue;
        }

        for(int j = 0; j < 3; j++){
          if(j == notEven){
            continue;
          }
          if("even".equals(result[i][j])){
            if(!((l[i][j].indexOf(ch) >= 0 && r[i][j].indexOf(ch) >= 0) ||
                  (l[i][j].indexOf(ch) == -1 && r[i][j].indexOf(ch) == -1))){
              flag = false;
            }
          }
          else if("up".equals(result[i][j])){
            if(isLight){
              if(!(l[i][j].indexOf(ch) == -1 && r[i][j].indexOf(ch) >= 0)){
                flag = false;
              }
            }
            else{
              if(!(l[i][j].indexOf(ch) >= 0 && r[i][j].indexOf(ch) == -1)){
                flag = false;
              }
            }
          }
          else if("down".equals(result[i][j])){
            if(isLight){
              if(!(l[i][j].indexOf(ch) >= 0 && r[i][j].indexOf(ch) == -1)){
                flag = false;
              }
            }
            else{
              if(!(l[i][j].indexOf(ch) == -1 && r[i][j].indexOf(ch) >= 0)){
                flag = false;
              }
            }
          }
        }

        if(flag){
          sb.append(ch + " is the counterfeit coin and it is " + 
              (isLight ? "light" : "heavy") + ".\n");
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
