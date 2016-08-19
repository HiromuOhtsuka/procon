import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    int[] re = new int[n + 1];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
      re[a[i]] = i;
    }

    int d = Math.abs(re[1] - re[n]);
    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        int tmp1 = a[i], tmp2 = re[a[i]];
        re[a[i]] = re[a[j]];
        re[a[j]] = tmp2;
        a[i] = a[j];
        a[j] = tmp1;
        d = Math.max(d, Math.abs(re[1] - re[n]));
        tmp1 = a[i]; tmp2 = re[a[i]];
        re[a[i]] = re[a[j]];
        re[a[j]] = tmp2;
        a[i] = a[j];
        a[j] = tmp1;
      }
    }

    System.out.println(d);
  }
}
