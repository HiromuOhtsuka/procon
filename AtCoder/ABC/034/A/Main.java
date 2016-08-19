import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int x = scan.nextInt(), y = scan.nextInt();
    if(y > x){
      System.out.println("Better");
    }
    else{
      System.out.println("Worse");
    }
  }
}
