import java.util.Scanner;

public class Main {
  static int n, b, d;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); b = sc.nextInt(); d = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sum = 0;
    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] <= b){
        sum += a[i];
      }
      if(sum > d){
        ++count;
        sum = 0;
      }
    }

    System.out.println(count);
  }
}
