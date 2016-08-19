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

    int even = 0;
    for(int i = 0; i < n; i++){
      if(a[i] % 2 == 0){
        ++even;
      }
      if(even % 2 == 0){
        System.out.println(2);
      }
      else{
        System.out.println(1);
      }
    }
  }
}
