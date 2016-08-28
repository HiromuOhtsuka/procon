import java.util.Scanner;

public class Main {
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();

    long sum = 0;
    long i;
    for(i = 1; sum < n; i++){
      sum += i;
    }

    long ans = (i - 1) - (sum - n);

    System.out.println(ans);
  }
}
