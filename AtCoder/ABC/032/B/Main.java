import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static String s;
  static int k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();  k = sc.nextInt();

    int n = s.length();

    Set< String > set = new TreeSet< String >();
    int i = 0, j = k;
    while(j <= n){
      String sub = s.substring(i, j);
      set.add(sub);
      i++; j++;
    }

    System.out.println(set.size());
  }
}
