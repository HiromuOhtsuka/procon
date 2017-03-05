import java.util.Scanner;

public class Main{
  static int n;
  static boolean[] pat;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    pat = new boolean[n];
    String line = sc.next();
    for(int i = 0; i < line.length(); i++){
      pat[i] = (line.charAt(i) == 'o');
    }

    boolean[] ans = null;

    boolean[] ss = search(true, true);
    if(ss != null){
      System.out.println(toAnswer(ss));
      return;
    }

    boolean[] sw = search(true, false);
    if(sw != null){
      System.out.println(toAnswer(sw));
      return;
    }

    boolean[] ws = search(false, true);
    if(ws != null){
      System.out.println(toAnswer(ws));
      return;
    }

    boolean[] ww = search(false, false);
    if(ww != null){
      System.out.println(toAnswer(ww));
      return;
    }

    System.out.println(-1);
  }

  private static boolean[] search(boolean s0, boolean s1){
    boolean[] s = new boolean[n];
    s[0] = s0;  s[1] = s1;

    for(int i = 1; i < n - 1; i++){
      if(pat[i]){
        s[(i + 1) % n] = s[(i - 1 + n) % n];
      }
      else{
        s[(i + 1) % n] = !s[(i - 1 + n) % n];
      }
      if(!s[i]){
        s[(i + 1) % n] = !s[(i + 1) % n];
      }
    }

    if(pat[0]){
      if(s[0]){
        if(s[n - 1] != s[1]){
          return null;
        }
      }
      else{
        if(s[n - 1] == s[1]){
          return null;
        }
      }
    }
    else{
      if(s[0]){
        if(s[n - 1] == s[1]){
          return null;
        }
      }
      else{
        if(s[n - 1] != s[1]){
          return null;
        }
      }
    }

    if(pat[n - 1]){
      if(s[n - 1]){
        if(s[n - 2] != s[0]){
          return null;
        }
      }
      else{
        if(s[n - 2] == s[0]){
          return null;
        }
      }
    }
    else{
      if(s[n - 1]){
        if(s[n - 2] == s[0]){
          return null;
        }
      }
      else{
        if(s[n - 2] != s[0]){
          return null;
        }
      }
    }

    return s;
  }

  private static String toAnswer(boolean[] a){
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < a.length; i++){
      if(a[i]){
        sb.append("S");
      }
      else{
        sb.append("W");
      }
    }
    return sb.toString();
  }
}
