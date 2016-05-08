import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    while(scan.hasNext()){
      int d = scan.nextInt();
      long sum = 0;
      for(int i=1; i<600/d; i++){
        sum += d*f(i*d);
      }
      System.out.println(sum);
    }
  }

  private static long f(int x){
    return (long)x*x;
  }
}
