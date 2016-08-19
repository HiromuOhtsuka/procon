import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int n = scan.nextInt();
    long sum = 0;
    int minEven = Integer.MAX_VALUE, count = 0;
    for(int i = 0; i < n; i++){
      int m = scan.nextInt();
      sum += m;
      if(m % 2 == 1){
        ++count;
        minEven = Math.min(minEven, m);
      }
    }
    if(count % 2 == 1){
      sum -= minEven;
    }

    System.out.println(sum);
  }
}
