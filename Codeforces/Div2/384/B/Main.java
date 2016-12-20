import java.util.Scanner;

public class Main {
  static long n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextLong();

    if(k % 2 == 1){
      System.out.println(1);
      return;
    }

    long step = 1, len = 1;
    while(len < k){
      len = 2 * len + 1;
      ++step;
    }

    while(k != len / 2 + 1){
      if(k < len / 2){
        k = k % (len / 2);
      }
      else{
        k = (k - 1) % (len / 2);
      }
      len = len / 2;
      --step;
    }

    System.out.println(step);
  }
}
