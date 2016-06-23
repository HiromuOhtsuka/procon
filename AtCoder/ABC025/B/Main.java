import java.util.Scanner;

public class Main {
  static int n, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); a = sc.nextInt(); b = sc.nextInt();
    int x = 0;
    for(int i = 0; i < n; i++){
      String s = sc.next();
      int d = sc.nextInt();
      if(d < a){
        d = a;
      }
      else if(d > b){
        d = b;
      }
      if("East".equals(s)){
        x += d;
      }
      else{
        x -= d;
      }
    }

    if(x > 0){
      System.out.println("East " + x);
    }
    else if(x < 0){
      System.out.println("West " + -x);
    }
    else{
      System.out.println(0);
    }
  }
}
