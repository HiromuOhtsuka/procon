import java.util.Scanner;

public class Main{
  static int a, b;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    a = sc.nextInt();
    b = sc.nextInt();
    int count = 1;
    boolean aIsLose = false;
    while(true){
      if(DEBUG){
        System.out.println(a + ", " + b);
      }
      if(count % 2 == 1){
        if(a - count < 0){
          aIsLose = true;
          break;
        }
        else{
          a -= count;
        }
      }
      else{
        if(b - count < 0){
          aIsLose = false;
          break;
        }
        else{
          b -= count;
        }
      }
      ++count;
    }

    if(aIsLose){
      System.out.println("Vladik");
    }
    else{
      System.out.println("Valera");
    }
  }
}
