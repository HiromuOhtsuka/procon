import java.util.Scanner;

public class Main{
  static long x, y;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    x = sc.nextLong();
    y = sc.nextLong();

    if((x == 0 && y == 0) ||
        (x == 0 && y == 1) || (x == 1 && y == 0)
        || (x == 1 && y == 1)){
      System.out.println("Brown");
      return;
    }

    if(x == 0 || y == 0){
      System.out.println("Alice");
      return;
    }

    if(Math.abs(x - y) <= 1){
      System.out.println("Brown");
      assert(!f(x, y));
    }
    else{
      System.out.println("Alice");
      assert(f(x, y));
    }
  }

  private static boolean f(long a, long b){
    if((a == 0 && b == 0) ||
        (a == 0 && b == 1) || (a == 1 && b == 0)
        || (a == 1 && b == 1)){
      return false;
    }

    for(long i = a / 2; i >= 1; i--){
      if(!f(a - 2 * i, b + i)){
        return true;
      }
    }
    for(long i = b / 2; i >= 1; i--){
      if(!f(a + i, b - 2 * i)){
        return true;
      }
    }
    return false;
  }
}
