import java.util.Scanner;

public class Main {
  static int m, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    m = sc.nextInt(); d = sc.nextInt();
    if(m % d == 0){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
