import java.util.Scanner;

public class Main {
  static int n;
  static int[] l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l = new int[n]; r = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt();  r[i] = sc.nextInt();
    }

    int ls = 0, rs = 0;
    for(int i = 0; i < n; i++){
      ls += l[i]; rs += r[i];
    }

    int i = 0, max = Math.abs(ls - rs);
    for(int j = 0; j < n; j++){
      int beauty = Math.abs((ls - rs) + 2 * (r[j] - l[j]));
      if(max < beauty){
        max = beauty;  i = j + 1;
      }
    }

    System.out.println(i);
  }
}
