import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    System.out.print("I hate");
    for(int i = 1; i < n; i++){
      if(i % 2 == 0){
        System.out.print(" that I hate");
      }
      else{
        System.out.print(" that I love");
      }
    }
    System.out.println(" it");
  }
}
