import java.util.Scanner;

public class Main {
  static char x;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.next().charAt(0);
    s = sc.next();

    char[] str = s.toCharArray();
    int n = s.length();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      if(str[i] != x){
        sb.append(str[i]);
      }
    }

    System.out.println(sb);
  }
}
