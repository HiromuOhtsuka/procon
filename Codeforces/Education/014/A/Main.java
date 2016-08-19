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

    if(n == 1){
      if(a[0] == 1){
        System.out.println("YES");
      }
      else{
        System.out.println("NO");
      }
      return;
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] == 1){
        ++count;
      }
    }

    if(n - count == 1){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
