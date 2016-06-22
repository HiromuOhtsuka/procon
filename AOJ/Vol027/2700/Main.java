import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n;
  static String[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);


    for(;;){
      n = sc.nextInt();

      if(n == 0){
        return;
      }

      s = new String[n];
      for(int i = 0; i < n; i++){
        s[i] = sc.next();
      }

      String[] cmp = new String[n];
      for(int i = 0; i < n; i++){
        char[] tmp = new char[s[i].length() + 1];
        int sp = 0;
        tmp[sp++] = s[i].charAt(0);
        boolean flag = isBoin(s[i].charAt(0));
        for(int j = 1; j < s[i].length(); j++){
          if(flag){
            tmp[sp++] = s[i].charAt(j);
          }
          flag = isBoin(s[i].charAt(j));
        }
        cmp[i] = new String(tmp, 0, sp);
      }

      boolean ok = false;
      int k = 1;
      while(k <= 51){
        Set< String > set = new TreeSet< String >();
        for(int i = 0; i < n; i++){
          if(k > cmp[i].length()){
            set.add(cmp[i]);
          }
          else{
            set.add(cmp[i].substring(0, k));
          }
        }
        if(set.size() == n){
          ok = true;
          System.out.println(k);
          break;
        }
        ++k;
      }

      if(!ok){
        System.out.println(-1);
      }
    }
  }

  private static boolean isBoin(char c){
    return c == 'a' || c == 'i' || c == 'u' ||
      c == 'e' || c == 'o';
  }
}
