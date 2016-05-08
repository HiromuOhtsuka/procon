import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();

    long sum = 2;
    for(long i = 2; i <= n; i++){
      sum = sum + (1L << i);
    }

    System.out.println(sum);
  }
}

