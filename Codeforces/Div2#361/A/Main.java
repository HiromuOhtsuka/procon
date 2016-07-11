import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n;
  static long a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextLong();

    Set< Long > set = new TreeSet< Long >();
    for(int i = 0; i < n; i++){
      set.add(a % 10);
      a /= 10;
    }

    if(set.contains(0L) && (set.contains(1L) || set.contains(2L) || set.contains(3L))){
      System.out.println("YES");
      return;
    }
    if(set.contains(1L) && set.contains(9L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(3L) && set.contains(7L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(2L) && set.contains(7L) && set.contains(9L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(1L) && set.contains(7L) && set.contains(6L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(3L) && set.contains(4L) && set.contains(9L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(2L) && set.contains(6L) && set.contains(7L)){
      System.out.println("YES");
      return;
    }
    if(set.contains(2L) && set.contains(4L) && set.contains(9L)){
      System.out.println("YES");
      return;
    }

    System.out.println("NO");
  }
}
