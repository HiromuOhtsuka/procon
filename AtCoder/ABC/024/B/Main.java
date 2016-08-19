import java.util.Scanner;

public class Main {
  static int n, t;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); t = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sum = 0;
    int s = a[0], e = a[0] + t;
    for(int i = 1; i < n; i++){
      if(s <= a[i] && a[i] <= e){
        sum += (a[i] - s);
      }
      else{
        sum += e - s;
      }
      s = a[i]; e = a[i] + t;
    }
    sum += e - s;

    System.out.println(sum);
  }
}
