import java.util.Scanner;

public class Main {
  static int q;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    q = sc.nextInt();
    if(q == 1){
      System.out.println("ABC");
    }
    else if(q == 2){
      System.out.println("chokudai");
    }
  }
}
