import java.util.Scanner;

public class Main {
  static long a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    if(a % 2 == 0 || b % 2 == 0 || c % 2 == 0){
      System.out.println(0);
    }
    else{
      System.out.println(Math.min(a * b, Math.min(b * c, a * c)));
    }
  }
}
