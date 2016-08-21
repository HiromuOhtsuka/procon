import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long count = 0, sum = 0;
    for(int i = 0; i < n; i++){
      if(a[i] == 0){
        count += sum / 2;
        sum = 0;
      }
      sum += a[i];
    }

    count += sum / 2;

    System.out.println(count);
  }
}
