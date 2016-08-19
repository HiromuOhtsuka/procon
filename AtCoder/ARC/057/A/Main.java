import java.util.Scanner;

public class Main {
  static final long INF = 2000000000000L;
  static long a, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextLong();  k = sc.nextLong();

    if(k == 0){
      System.out.println(INF - a);
      return;
    }

    long sum = a, i = 0;
    while(sum < INF){
      sum = sum + 1 + k * sum;
      ++i;
    }

    System.out.println(i);
  }
}
