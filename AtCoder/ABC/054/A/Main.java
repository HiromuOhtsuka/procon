import java.util.Scanner;

public class Main{
  static int a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();  b = sc.nextInt();
    if(a == 1){
      a = 14;
    }
    if(b == 1){
      b = 14;
    }

    if(a < b){
      System.out.println("Bob");
    }
    else if(a > b){
      System.out.println("Alice");
    }
    else{
      System.out.println("Draw");
    }
  }
}
