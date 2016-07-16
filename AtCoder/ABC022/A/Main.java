import java.util.Scanner;

public class Main {
  static int n, s, t, w;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); s = sc.nextInt(); t = sc.nextInt();
    w = sc.nextInt();
    a = new int[n];
    a[0] = w;
    for(int i = 1; i < n; i++){
      a[i] = sc.nextInt();
    }

    int count = 0, sum = 0;
    for(int i = 0; i < n; i++){
      sum += a[i];
      if(s <= sum && sum <= t){
        ++count;
      }
    }

    System.out.println(count);
  }
}
