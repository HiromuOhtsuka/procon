import java.util.Scanner;

public class Main {
  static String str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();
    int n = str.length();
    char s = str.charAt(0), t = str.charAt(n - 1);

    if((n % 2 == 0 && s != t) || (n % 2 == 1 && s == t)){
      System.out.println("Second");
    }
    else{
      System.out.println("First");
    }
  }
}
