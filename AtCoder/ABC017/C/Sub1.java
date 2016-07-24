import java.util.Scanner;

public class Sub1 {
  static int n, m;
  static int[] l, r, s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    if(n > 8 || m > 8){
      return;
    }

    l = new int[n]; r = new int[n]; s = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt() - 1; r[i] = sc.nextInt(); s[i] = sc.nextInt();
    }

    int max = 0;
    for(int i = 0; i < (1 << n); i++){
      int table = 0, sum = 0;
      for(int j = 0; j < n; j++){
        if((i & (1 << j)) != 0){
          table |= (((1 << r[j]) - 1) - ((1 << l[j]) - 1));
          sum += s[j];
        }
      }
      if(table != ((1 << m) - 1)){
        max = Math.max(max, sum);
      }
    }

    System.out.println(max);
  }
}
