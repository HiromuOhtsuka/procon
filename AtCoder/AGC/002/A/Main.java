import java.util.Scanner;

public class Main {
  static long a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();

    if(a <= 0 && 0 <= b){
      System.out.println("Zero");
      return;
    }

    if(a < 0 && b < 0){
      if((b - a) % 2L == 0L){
        System.out.println("Negative");
      }
      else{
        System.out.println("Positive");
      }
    }
    else{
      System.out.println("Positive");
    }
  }
}
