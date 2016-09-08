import java.util.Scanner;

public class Main {
  static int n, m;
  static int[] d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    d = new int[m];
    for(int i = 0; i < m; i++){
      d[i] = sc.nextInt();
    }

    int[] c = new int[n + 1];
    for(int i = 0; i <= n; i++){
      c[i] = i;
    }

    int p = 0;
    for(int i = 0; i < m; i++){
      for(int j = 1; j <= n; j++){
        if(c[j] == d[i]){
          int tmp = c[j];  c[j] = p;  p = tmp;
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 1; i <= n; i++){
      sb.append(c[i]);
      sb.append(System.lineSeparator());
    }

    System.out.print(sb);
  }
}
