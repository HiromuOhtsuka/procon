import java.util.Scanner;

public class Main{
  static int n, m;
  static int[] p;
  static int[] l, r, x;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    p = new int[n];
    for(int i = 0; i < n; i++){
      p[i] = sc.nextInt();
    }
    l = new int[m];
    r = new int[m];
    x = new int[m];
    for(int i = 0; i < m; i++){
      l[i] = sc.nextInt() - 1;
      r[i] = sc.nextInt();
      x[i] = sc.nextInt() - 1;
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < m; i++){
      int count = 0;
      int pos = -1;
      for(int j = l[i]; j < r[i]; j++){
        if(p[x[i]] == p[j]){
          pos = j - l[i] + 1;
        }
        if(p[j] <= p[x[i]]){
          ++count;
        }
      }
      if(pos == -1 || count == pos){
        sb.append("Yes\n");
      }
      else{
        sb.append("No\n");
      }
    }

    System.out.print(sb);
  }
}
