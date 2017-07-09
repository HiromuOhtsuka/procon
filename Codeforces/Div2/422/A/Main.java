import java.util.Scanner;

public class Main{
  static int a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();

    int ans = 1;
    for(int i = 2; i <= Math.min(a, b); i++){
      ans *= i;
    }

    System.out.println(ans);
  }
}
