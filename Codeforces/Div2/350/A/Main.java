import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    if(n == 1){
      System.out.println(0 + " " + 1);
      return;
    }

    if(n % 7 == 0){
      System.out.println(2 * (n / 7) + " " + 2 * (n / 7));
      return;
    }

    int max = 2 * (n / 7);
    int min = 2 * (n / 7);

    if(n % 7 >= 6){
      min += n % 7 - 5;
    }

    if(n % 7 == 1){
      ++max;
    }
    else if(n % 7 >= 2){
      max += 2;
    }

    System.out.println(min + " " + max);
  }
}
