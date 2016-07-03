import java.util.Scanner;

public class Main {
  static String s;
  static int i;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    i = sc.nextInt();

    System.out.println(s.charAt(i - 1));
  }
}
