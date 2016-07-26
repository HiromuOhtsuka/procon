import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    int count = 0;
    double sum = 0;
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      sum += (double)a[i];
      if(a[i] == 0){
        ++count;
      }
    }

    double ave = sum / (double)(n - count);

    System.out.println(Math.round(ave));
  }
}
