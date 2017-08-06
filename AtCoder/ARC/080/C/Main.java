import java.util.Scanner;

public class Main{
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] % 2 == 0){
        ++count;
      }
    }
    if(count == n){
      System.out.println("Yes");
      return;
    }


    int count2 = 0, count4 = 0;
    for(int i = 0; i < n; i++){
      if(a[i] % 4 == 0){
        ++count4;
      }
      else if(a[i] % 2 == 0){
        ++count2;
      }
    }

    if((n - (count2 / 2) * 2) / 2 <= count4){
      System.out.println("Yes");
    }
    else{
      System.out.println("No");
    }
  }
}
