import java.util.Scanner;

public class Main {
  static int n;
  static long x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); x = sc.nextInt();
    int count = 0;
    for(int i = 0; i < n; i++){
      char op = sc.next().charAt(0);
      int d = sc.nextInt();
      if(op == '+'){
        x += d;
      }
      else{
        x -= d;
      }
      if(x < 0){
        ++count;
        x += d;
      }
    }

    System.out.println(x + " " + count);
  }
}
