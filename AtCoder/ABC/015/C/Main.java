import java.util.Scanner;

public class Main {
  static int n, k;
  static int[][] t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    t = new int[n][k];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < k; j++){
        t[i][j] = sc.nextInt();
      }
    }

    if(isBug(0, 0)){
      System.out.println("Found");
    }
    else{
      System.out.println("Nothing");
    }
  }

  private static boolean isBug(int i, int v){
    if(i == n){
      return v == 0;
    }

    for(int j = 0; j < k; j++){
      if(isBug(i + 1, v ^ t[i][j])){
        return true;
      }
    }

    return false;
  }
}
