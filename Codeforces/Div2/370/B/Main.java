import java.util.Scanner;

public class Main {
  static String s;
  static final int U = 0, L = 1, D = 2, R = 3;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    int n = s.length();

    if(n % 2 == 1){
      System.out.println(-1);
      return;
    }

    int[] counts = new int[4];
    for(int i = 0; i < n; i++){
      char ch = s.charAt(i);
      switch(ch){
        case 'U' : ++counts[U]; break;
        case 'L' : ++counts[L]; break;
        case 'D' : ++counts[D]; break;
        case 'R' : ++counts[R]; break;
      }
    }

    int r = n;
    r -= Math.min(counts[U], counts[D]) * 2;
    r -= Math.min(counts[R], counts[L]) * 2;
    r /= 2;

    System.out.println(r);
  }
}
