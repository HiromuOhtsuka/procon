import java.util.Scanner;

public class Main{
  static int w, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    w = sc.nextInt();
    a = sc.nextInt();
    b = sc.nextInt();

    int d = 0;
    if(a < b && a + w < b){
      d = b - (a + w);
    }
    if(a > b && b + w < a){
      d = a - (b + w);
    }

    System.out.println(d);
  }
}
