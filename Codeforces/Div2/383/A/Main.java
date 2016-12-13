import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int ans = 0;
    switch((n - 1) % 4){
      case 0: ans = 8; break;
      case 1: ans = 4; break;
      case 2: ans = 2; break;
      case 3: ans = 6; break;
    }

    if(n == 0){
      ans = 1;
    }

    System.out.println(ans);
  }
}
