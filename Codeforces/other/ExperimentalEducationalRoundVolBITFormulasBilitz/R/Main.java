import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    long n = scan.nextLong();
    if(n % 2L == 0){
      System.out.println("2");
    }
    else{
      System.out.println("1");
    }
  }
}
