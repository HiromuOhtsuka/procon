import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    if(n != 1){
      System.out.println(n + " " + (n + 1) + " " + (n * (n + 1)));
    }
    else{
      System.out.println(-1);
    }
  }
}
