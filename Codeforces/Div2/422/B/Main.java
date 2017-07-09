import java.util.Scanner;

public class Main{
  static int n, m;
  static char[] s, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    s = sc.next().toCharArray();
    t = sc.next().toCharArray();

    int min = n + 1;
    boolean[] minRep = new boolean[n];
    for(int i = 0; i < m - n + 1; i++){
      int count = 0;
      boolean[] rep = new boolean[n];
      for(int j = 0; j < n; j++){
        if(s[j] != t[i + j]){
          rep[j] = true;
          ++count;
        }
      }
      if(count < min){
        min = count;
        minRep = rep;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(min + System.lineSeparator());
    for(int i = 0; i < n; i++){
      if(minRep[i]){
        sb.append((i + 1) + " ");
      }
    }

    System.out.println(sb);
  }
}
