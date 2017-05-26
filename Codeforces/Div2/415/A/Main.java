import java.util.Scanner;

public class Main{
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sum = 0;
    for(int i = 0; i < n; i++){
      sum += a[i];
    }
    int count = 0;
    while(true){
      if((double)sum / (double)(n + count) >= (double)k - 0.5){
        break;
      }
      sum += k;
      ++count;
    }

    System.out.println(count);
  }
}
