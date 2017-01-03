import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    int max = 1;
    for(int i = 2; i * i <= n; i++){
      if(n % i == 0){
        max = Math.max(max, i);
      }
    }

    System.out.println(max + " " + (n / max));
  }
}
