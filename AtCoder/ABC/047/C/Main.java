import java.util.Scanner;

public class Main {
  static String S;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    S = sc.next();

    StringBuilder sb = new StringBuilder();
    sb.append(S.charAt(0));
    for(int i = 1; i < S.length(); i++){
      if(S.charAt(i - 1) != S.charAt(i)){
        sb.append(S.charAt(i));
      }
    }

    int ans = Math.max(0, sb.length() - 1);

    System.out.println(ans);
  }
}
