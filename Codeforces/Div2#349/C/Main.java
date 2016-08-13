import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();

    Set< String > set = new TreeSet< String >();
    int n = s.length();
    boolean[] div = new boolean[n + 1];
    String[][] divs = new String[n + 1][2];
    div[n] = true;
    for(int i = n - 1; i >= 5; i--){
      if(i + 1 < n && div[i + 2]){
        String str = s.substring(i, i + 2);
        if(divs[i + 2][0] == null || divs[i + 2][1] != null || !divs[i + 2][0].equals(str)){
          set.add(str);
          div[i] = true;
          divs[i][0] = str;
        }
      }
      if(i + 2 < n && div[i + 3]){
        String str = s.substring(i, i + 3);
        if(divs[i + 3][1] == null || divs[i + 3][0] != null || !divs[i + 3][1].equals(str)){
          set.add(str);
          div[i] = true;
          divs[i][1] = str;
        }
      }
    }

    System.out.println(set.size());
    for(String str : set){
      System.out.println(str);
    }
  }
}
