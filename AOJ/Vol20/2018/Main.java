import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      int n = scan.nextInt();
      if(n == 0)
        break;
      int[] x = new int[n];
      int m = scan.nextInt();
      int p = scan.nextInt();
      double sum = 0.0;
      for(int i=0;i<n;i++){
        x[i] = scan.nextInt();
        sum += x[i]*100;
      }
      sum -= sum * p / 100.0;
      int money;
      if(x[m-1] != 0){
        money = (int)(sum / x[m-1]);
      }
      else{
        money = 0;
      }
      System.out.println(money);
    }
  }
}
