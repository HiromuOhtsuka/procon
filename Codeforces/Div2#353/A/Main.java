import java.util.Scanner;

public class Main {
  static int a, b, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt(); b = sc.nextInt();
    c = sc.nextInt();

    if(c == 0){
      if(a == b){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
    else{
      if((b - a) % c == 0 && (b - a) / c >= 0){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
    }
  }
}
