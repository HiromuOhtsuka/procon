import java.util.Scanner;

public class Main {
  static long b, d, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    b = sc.nextLong(); d = sc.nextLong(); s = sc.nextLong();

    long max = Math.max(b, Math.max(d, s)), ans = 0;
    if(max == 1){
      System.out.println(0);
      return;
    }
    else{
      if(max == b && max == d && max == s){
        ans = 0;
      }
      else if(max == s){
        if(max == b){
          ans = max - 1 - d;
        }
        else if(max == d){
          ans = max - 1 - b;
        }
        else{
          ans = max - 1 - b + max - 1 - d;
        }
      }
      else if(max == d){
        if(max == b){
          ans = max - 1 - s;
        }
        else{
          ans = max - 1 - b + max - 1 - s;
        }
      }
      else if(max == b){
        ans = max - 1 - d + max - 1 - s;
      }
    }

    System.out.println(ans);
  }
}
