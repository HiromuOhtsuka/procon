import java.util.Scanner;

public class Main{
  static int q;
  static long n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextLong();
    q = sc.nextInt();
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++){
      long u = sc.nextLong();
      String path = sc.next();
      for(int j = 0; j < path.length(); j++){
        char op = path.charAt(j);
        if(op == 'U'){
          u = up(u);
        }
        else if(op == 'L'){
          u = left(u);
        }
        else if(op == 'R'){
          u = right(u);
        }
      }
      sb.append(u + System.lineSeparator());
    }
    System.out.println(sb);
  }

  private static long up(long x){
    long tmp = x & -x;
    long p1 = x + tmp;
    long p2 = x - tmp;
    long result = x;
    if(left(p1) == x){
      result = p1;
    }
    else if(right(p2) == x){
      result = p2;
    }
    return result < n ? result : x;
  }

  private static long left(long x){
    if((x & 1L) != 0L){
      return x;
    }
    long tmp = x & -x;
    return x - (tmp >> 1);
  }

  private static long right(long x){
    if((x & 1L) != 0L){
      return x;
    }
    long tmp = x & -x;
    return x + (tmp >> 1);
  }
}
