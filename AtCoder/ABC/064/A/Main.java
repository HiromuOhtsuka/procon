import java.util.Scanner;

public class Main{
  static int r, g, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt();
    g = sc.nextInt();
    b = sc.nextInt();

    if((r * 100 + g * 10 + b) % 4 == 0){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
