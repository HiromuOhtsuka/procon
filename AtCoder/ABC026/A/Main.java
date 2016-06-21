import java.util.Scanner;

public class Main {
  static int a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    int ans = -1;
    for(int x = 1; x <= 100; x++){
      for(int y = 1; y <= 100; y++){
        if(x + y == a){
          ans = Math.max(ans, x * y);
        }
      }
    }

    System.out.println(ans);
  }
}
