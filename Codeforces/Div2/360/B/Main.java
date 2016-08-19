import java.util.Scanner;

public class Main {
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();

    System.out.print(str);
    for(int i = str.length() - 1; i >= 0; i--){
      System.out.print(str.charAt(i));
    }
    System.out.println();
  }
}
