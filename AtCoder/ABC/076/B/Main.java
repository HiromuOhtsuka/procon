import java.util.Scanner;

public class Main{
  static int n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    int a = 1;
    for(int i = 0; i < n; i++){
      a = Math.min(a + k, 2 * a);
    }

    System.out.println(a);
  }
}
