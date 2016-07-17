import java.util.Scanner;

public class Main {
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();
    int n = str.length();
    char[] s = str.toCharArray();

    StringBuilder sb = new StringBuilder();
    int i = 0, j = 0;
    while(j < n){
      while(j < n && s[i] == s[j]){
        ++j;
      }
      sb.append(s[i]);
      sb.append(Integer.toString(j - i));
      i = j;
    }

    System.out.println(sb.toString());
  }
}
