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

    String ans = "";
    if(a[n - 1] == 0){
      ans = "UP";
    }
    else if(a[n - 1] == 15){
      ans = "DOWN";
    }
    else if(n == 1){
      ans = "-1";
    }
    else{
      if(a[n - 2] < a[n - 1]){
        ans = "UP";
      }
      else{
        ans = "DOWN";
      }
    }

    System.out.println(ans);
  }
}
