import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();
    int n = str.length();
    String s = str + str;
    Set< String > set = new TreeSet< String >();
    for(int i = 0; i < n; i++){
      set.add(s.substring(i, i + n));
    }

    int ans = set.size();

    System.out.println(ans);
  }
}
