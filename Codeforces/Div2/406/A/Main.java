import java.util.Scanner;

public class Main{
  static int a, b;
  static int c, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();
    d = sc.nextInt();

    int i = 0, j = 0;
    while(i < 100 && j < 100){
      if(b + a * i == d + c * j){
        System.out.println(b + a * i);
        return;
      }
      if(b + a * i < d + c * j){
        ++i;
      }
      else{
        ++j;
      }
    }

    System.out.println(-1);
  }
}
