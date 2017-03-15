import java.util.Scanner;

public class Main{
  static int n;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    b = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }

    int[] ca = new int[5];
    int[] cb = new int[5];
    for(int i = 0; i < n; i++){
      ca[a[i] - 1]++;
      cb[b[i] - 1]++;
    }

    int sum = 0;
    for(int i = 0; i < 5; i++){
      int diff = Math.abs(ca[i] - cb[i]);
      if(diff % 2 != 0){
        System.out.println(-1);
        return;
      }
      sum += diff / 2;
    }

    if(sum % 2 == 0){
      System.out.println(sum / 2);
    }
    else{
      System.out.println(sum / 2 + 1);
    }
  }
}
