import java.util.Scanner;

public class Main {
  static int n, m;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    long count = 0;
    for(int i = 1; i <= n; i++){
      if(m - (5 - (i % 5)) >= 0){
        count += (m - (5 - (i % 5))) / 5 + 1;
      }
    }

    System.out.println(count);
  }
}
