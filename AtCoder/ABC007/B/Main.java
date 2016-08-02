import java.util.Scanner;

public class Main {
  static String a;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.next();
    if("a".equals(a)){
      System.out.println(-1);
    }
    else{
      System.out.println("a");
    }
  }
}
