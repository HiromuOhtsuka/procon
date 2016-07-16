import java.util.Scanner;

public class Main {
  static final int MAX = 100000;
  static int n;
  static int[] a, c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    c = new int[MAX + 1];
    for(int i = 0; i < n; i++){
      ++c[a[i]];
    }

    int count = 0;
    for(int i = 0; i <= MAX; i++){
      if(c[i] > 0){
        count += c[i] - 1;
      }
    }

    System.out.println(count);
  }
}
