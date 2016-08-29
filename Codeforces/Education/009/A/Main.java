import java.util.Scanner;

public class Main {
  static int n, p;
  static String[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); p = sc.nextInt();
    s = new String[n];
    for(int i = 0; i < n; i++){
      s[i] = sc.next();
    }

    long sum = 1;
    for(int i = n - 2; i >= 0; i--){
      if(s[i].equals("half")){
        sum += sum;
      }
      else{
        sum += sum + 1 ;
      }
    }

    long cost = 0;
    for(int i = 0; i < n; i++){
      if(s[i].equals("half")){
        cost += sum / 2 * p;
        sum -= sum / 2;
      }
      else{
        cost += sum / 2 * p;
        cost += p / 2;
        sum -= sum / 2 + 1;
      }
    }

    System.out.println(cost);
  }
}
