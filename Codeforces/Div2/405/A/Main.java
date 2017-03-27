import java.util.Scanner;

public class Main{
  static int a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();

    int i = 0;
    int tri = 1, dou = 1;
    while(a * tri <= b * dou){
      tri *= 3;
      dou *= 2;
      ++i;
    }

    System.out.println(i);
  }
}
