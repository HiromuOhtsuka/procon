import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static String[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = new String[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.next();
    }

    String[] rs = new String[n];
    for(int i = 0; i < n; i++){
      rs[i] = new StringBuilder(s[i]).reverse().toString();
    }

    Arrays.sort(rs);

    for(int i = 0; i < n; i++){
      s[i] = new StringBuilder(rs[i]).reverse().toString();
    }

    for(int i = 0; i < n; i++){
      System.out.println(s[i]);
    }
  }
}
