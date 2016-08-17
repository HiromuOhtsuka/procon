import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int ans = 1;
    if(n % 3 == 0){
      ans = 2 * (n / 3);
    }
    else if(n % 3 == 1){
      ans = 3 + 2 * (n / 3 - 1);
    }
    else{
      ans = 3 + 2 * ((n - 1) / 3 - 1);
    }

    System.out.println(ans);
  }
}
