import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    if(a + b == c && a - b == c){
      System.out.println("?");
    }
    else if(a + b == c){
      System.out.println("+");
    }
    else if(a - b == c){
      System.out.println("-");
    }
    else{
      System.out.println("!");
    }
  }
}
