import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt(); c = sc.nextInt();

    if(a == 7 && b == 5 && c == 5 ||
      a == 5 && b == 7 && c == 5 ||
      a == 5 && b == 5 && c == 7){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
