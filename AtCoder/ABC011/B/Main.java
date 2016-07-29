import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();

    char[] ans = new char[s.length()];
    ans[0] = Character.toUpperCase(s.charAt(0));
    for(int i = 1; i < s.length(); i++){
      ans[i] = Character.toLowerCase(s.charAt(i));
    }

    System.out.println(ans);
  }
}
