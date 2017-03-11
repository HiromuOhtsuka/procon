import java.util.Scanner;

public class Main{
  static int n;
  static int[] x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x = new int[2 * n];
    for(int i = 0; i < 2 * n; i++){
      x[i] = sc.nextInt() - 1;
    }

    boolean[] a = new boolean[n];
    int max = 1;
    int count = 0;
    for(int i = 0; i < 2 * n; i++){
      if(!a[x[i]]){
        a[x[i]] = true;
        ++count;
      }
      else{
        --count;
      }
      max = Math.max(max, count);
    }

    System.out.println(max);
  }
}
