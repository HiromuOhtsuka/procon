import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    String s = sc.next();

    int ans = s.charAt(0) - 'A' + 1;

    System.out.println(ans);
  }
}
