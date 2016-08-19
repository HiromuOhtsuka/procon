import java.util.Scanner;

public class Main {
  static long n;
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();

    long m = n;
    int depth = 0;
    while(m != 0){
      ++depth;
      m /= 2;
    }

    boolean flag = true;
    m = 1;
    if(depth % 2 == 0){
      while(m <= n){
        if(flag){
          m = 2 * m;
        }
        else{
          m = 2 * m + 1;
        }
        flag = !flag;
      }
    }
    else{
      while(m <= n){
        if(flag){
          m = 2 * m + 1;
        }
        else{
          m = 2 * m;
        }
        flag = !flag;
      }
    }

    if(flag){
      System.out.println("Takahashi");
    }
    else{
      System.out.println("Aoki");
    }
  }
}
