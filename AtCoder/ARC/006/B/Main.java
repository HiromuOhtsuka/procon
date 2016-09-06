import java.util.Scanner;

public class Main {
  static int n, l, s;
  static boolean[][][] amida;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); l = sc.nextInt();
    amida = new boolean[l][n][n];
    sc.nextLine();
    for(int i = 0; i < l; i++){
      String line = sc.nextLine();
      int c = 0;
      for(int j = 0; j < line.length(); j += 2){
        if(j + 1 < line.length() && line.charAt(j + 1) == '-'){
          amida[i][c][c + 1] = amida[i][c + 1][c] = true;
        }
        ++c;
      }
    }
    s = sc.nextLine().indexOf('o') / 2;

    int[] pos = new int[n];
    for(int i = 0; i < n; i++){
      pos[i] = i;
    }

    for(int i = l - 1; i >= 0; i--){
      for(int j = 0; j < n - 1; j++){
        if(amida[i][j][j + 1]){
          int tmp = pos[j];
          pos[j] = pos[j + 1];
          pos[j + 1] = tmp;
        }
      }
    }

    int ans = 0;
    for(int i = 0; i < n; i++){
      if(pos[i] == s){
        ans = i + 1;
        break;
      }
    }

    System.out.println(ans);
  }
}
