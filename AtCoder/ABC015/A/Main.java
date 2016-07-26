import java.util.Scanner;

public class Main {
  static String a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.next();  b = sc.next();

    if(a.length() < b.length()){
      System.out.println(b);
    }
    else{
      System.out.println(a);
    }
  }
}
