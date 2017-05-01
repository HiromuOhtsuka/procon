import java.util.Scanner;

public class Main{
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static char[][] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = new char[n][];
    for(int i = 0; i < n; i++){
      s[i] = sc.next().toCharArray();
    }

    int[][] counts = new int[n][26];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < s[i].length; j++){
        ++counts[i][s[i][j] - 'a'];
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < 26; i++){
      int min = INF;
      for(int j = 0; j < n; j++){
        min = Math.min(min, counts[j][i]);
      }
      if(min != 0){
        for(int j = 0; j < min; j++){
          sb.append((char)(i + 'a'));
        }
      }
    }

    System.out.println(sb);
  }
}
