import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    int h = n / 3600, m = (n - 3600 * h) / 60, s = n % 60;

    if(h >= 10){
      System.out.print(h);
    }
    else{
      System.out.print("0" + h);
    }
    if(m >= 10){
      System.out.print(":" + m);
    }
    else{
      System.out.print(":0" + m);
    }
    if(s >= 10){
      System.out.println(":" + s);
    }
    else{
      System.out.println(":0" + s);
    }
  }
}
