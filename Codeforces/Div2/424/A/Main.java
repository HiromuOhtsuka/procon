import java.util.Scanner;

public class Main{
  static int n;
  static int[] a;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    if(n == 1){
      System.out.println("YES");
      return;
    }

    int s = 0;
    while(s + 1 < n && a[s] < a[s + 1]){
      ++s;
    }
    while(s + 1 < n && a[s] == a[s + 1]){
      ++s;
    }
    while(s + 1 < n && a[s] > a[s + 1]){
      ++s;
    }

    if(DEBUG){
      System.out.println("s = " + s);
    }

    if(s + 1 == n){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
