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

    int count = 0;
    int i = 0;
    while(i < n){
      boolean flag = false;
      if(a[i] % 2 == 0){
        a[i] -= 1;
        flag = true;
        ++count;
      }
      if(a[i] % 3 == 2){
        a[i] -= 1;
        flag = true;
        ++count;
      }
      if(!flag){
        ++i;
      }
    }

    System.out.println(count);
  }
}
