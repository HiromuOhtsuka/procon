import java.util.Scanner;

public class Main {
  static int s, x1, x2, t1, t2, p, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.nextInt(); x1 = sc.nextInt();  x2 = sc.nextInt();
    t1 = sc.nextInt();  t2 = sc.nextInt();
    p = sc.nextInt(); d = sc.nextInt();

    int ans = t2 * Math.abs(x1 - x2);

    if(t1 >= t2){
      System.out.println(ans);
      return;
    }

    if(p == x1){
      if(d == 1 && x1 < x2){
        ans = Math.min(ans, (x2 - x1) * t1);
      }
      if(d == -1 && x1 > x2){
        ans = Math.min(ans, (x1 - x2) * t1);
      }
    }

    if(p <= x1){
      if(d == 1){
        if(x1 < x2){
          ans = Math.min(ans, (x2 - p) * t1);
        }
        else{
          ans = Math.min(ans, (s - p + s - x2) * t1);
        }
      }
      else{
        if(x1 < x2){
          ans = Math.min(ans, (p + x2) * t1);
        }
        else{
          ans = Math.min(ans, (p + s + (s - x2)) * t1);
        }
      }
    }
    else{
      if(d == 1){
        if(x1 <= x2){
          ans = Math.min(ans, (s - p + s + x2) * t1);
        }
        else{
          ans = Math.min(ans, (s - p + s - x2) * t1);
        }
      }
      else{
        if(x1 <= x2){
          ans = Math.min(ans, (p + x2) * t1);
        }
        else{
          ans = Math.min(ans, (p - x2) * t1);
        }
      }
    }

    System.out.println(ans);
  }
}
