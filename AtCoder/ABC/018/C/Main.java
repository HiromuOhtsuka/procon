import java.util.Scanner;

public class Main {
  static int r, c, k;
  static int[][] table;
  static int[][] dp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    r = sc.nextInt(); c = sc.nextInt(); k = sc.nextInt();

    table = new int[r][c];
    sc.nextLine();
    for(int i = 0; i < r; i++){
      String line = sc.nextLine();
      for(int j = 0; j < c; j++){
        char ch = line.charAt(j);
        if(ch != 'o'){
          table[i][j] = 1;
        }
      }
    }

    dp = new int[r][c];
    for(int j = 0; j < c; j++){
      if(table[0][j] == 0){
        dp[0][j] = 1;
      }
    }
    for(int j = 0; j < c; j++){
      for(int i = 1; i < r; i++){
        if(table[i][j] == 0){
          dp[i][j] = dp[i - 1][j] + 1;
        }
        else{
          dp[i][j] = 0;
        }
      }
    }

    int count = 0;
    for(int x = k - 1; x <= r - k; x++){
      for(int y = k - 1; y <= c - k; y++){
        if(check(y, x)){
          ++count;
        }
      }
    }

    System.out.println(count);
  }

  private static boolean check(int x, int y){
    for(int j = x - k + 1; j <= x; j++){
      if(!(dp[y][j] >= (j - x + k))){
        return false;
      }
      if(!(dp[y + (j - x + k) - 1][j] >= 2 * (j - x + k) - 1)){
        return false;
      }
    }
    for(int j = x + 1; j < x + k; j++){
      if(!(dp[y][j] >= (-j + x + 1 + k - 1))){
        return false;
      }
      if(!(dp[y + (-j + x + 1 + k - 1) - 1][j] >= 2 * (-j + x + 1 + k - 1) - 1)){
        return false;
      }
    }
    return true;
  }
}
