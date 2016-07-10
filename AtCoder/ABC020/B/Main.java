import java.util.Scanner;

public class Main {
  static String a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.next();  b = sc.next();
    a = a + b;

    System.out.println(Integer.parseInt(a) * 2);
  }
}
