import java.util.Scanner;

public class Main{
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();
    c = sc.nextInt();

    for(int i = 1; i <= 100; i++){
      if(a * i % b == c){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
