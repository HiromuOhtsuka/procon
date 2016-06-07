import java.util.Scanner;

public class Main {
  static int n, h;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); h = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int w = n;
    for(int i = 0; i < n; i++){
      if(a[i] > h){
        ++w;
      }
    }

    System.out.println(w);
  }
}
