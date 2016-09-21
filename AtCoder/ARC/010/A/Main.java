import java.util.Scanner;

public class Main {
  static int n, m, a, b;
  static int[] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();
    c = new int[m];
    for(int i = 0; i < m; i++){
      c[i] = sc.nextInt();
    }

    int sum = n;
    for(int i = 0; i < m; i++){
      if(sum <= a){
        sum += b;
      }
      sum -= c[i];
      if(sum < 0){
        System.out.println(i + 1);
        return;
      }
    }

    System.out.println("complete");
  }
}
