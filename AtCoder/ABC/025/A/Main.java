import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static char[] s;
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String line = sc.next();
    s = new char[5];
    for(int i = 0; i < 5; i++){
      s[i] = line.charAt(i);
    }
    n = sc.nextInt();

    String[] ss = new String[5 * 5];
    int sp = 0;
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        ss[sp++] = ("" + s[i] + "" + s[j]);
      }
    }
    Arrays.sort(ss);

    System.out.println(ss[n - 1]);
  }
}
