import java.util.Scanner;

public class Main {
  static int a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();

    int ans = 0;
    if(a % b != 0){
      ans = (a / b + 1) * b - a;
    }
    System.out.println(ans);
  }
}
