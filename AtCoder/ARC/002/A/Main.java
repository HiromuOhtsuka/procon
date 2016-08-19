import java.util.Scanner;

public class Main {
  static int y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    y = sc.nextInt();

    boolean ans = false;
    if(y % 400 == 0){
      ans = true;
    }
    else if(y % 100 == 0){
      ans = false;
    }
    else if(y % 4 == 0){
      ans = true;
    }
    else{
      ans = false;
    }

    if(ans){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
