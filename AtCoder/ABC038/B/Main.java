import java.util.Scanner;

public class Main {
  static int h1, w1, h2, w2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    h1 = sc.nextInt();  w1 = sc.nextInt();
    h2 = sc.nextInt();  w2 = sc.nextInt();

    if(h1 == h2 || h1 == w2 || w1 == h2 || w1 == w2){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
