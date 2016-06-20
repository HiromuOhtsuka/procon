import java.util.Scanner;

public class Main {
  static int w, h;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    w = sc.nextInt(); h = sc.nextInt();
    if(4 * h == 3 * w){
      System.out.println("4:3");
    }
    else{
      System.out.println("16:9");
    }
  }
}
