import java.util.Scanner;

public class Main{
  static int x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextInt();
    if(x < 1200){
      System.out.println("ABC");
    }
    else{
      System.out.println("ARC");
    }
  }
}
