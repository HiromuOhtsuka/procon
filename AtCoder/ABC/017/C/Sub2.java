import java.util.Scanner;

public class Sub2 {
  static int n, m;
  static int[] l, r, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    l = new int[n]; r = new int[n]; s = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt() - 1; r[i] = sc.nextInt() - 1; s[i] = sc.nextInt();
    }

    int max = 0;
    for(int i = 0; i < m; i++){
      int sum = 0;
      for(int j = 0; j < n; j++){
        if(!(l[j] <= i && i <= r[j])){
          sum += s[j];
        }
      }
      max = Math.max(max, sum);
    }

    System.out.println(max);
  }
}
