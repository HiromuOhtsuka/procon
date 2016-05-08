import java.util.Scanner;

public final class Main {
  public static final int MAX_N = 100;
  private int[] dp;

  public Main(){
    dp = new int[MAX_N];
    Scanner scan = new Scanner(System.in);
    int m = 0;

    while(scan.hasNext()){
      String line = scan.nextLine();
      String[] data = line.split(",");
      if(m < data.length){
        for(int j = data.length - 1; j >= 1; j--){
          int n = Integer.parseInt(data[j]);
          dp[j] = max(n + dp[j], n + dp[j - 1]);
        }
        int num = Integer.parseInt(data[0]);
        dp[0] = dp[0] + num;
      }
      else{
        for(int j = 0; j < data.length; j++){
          int n = Integer.parseInt(data[j]);
          dp[j] = max(n + dp[j], n + dp[j + 1]);
        }
      }
      m = data.length;
    }
    System.out.println(dp[0]);
  }

  private int max(int a, int b){
    return a < b ? b : a;
  }

  public static void main(String[] args){
    new Main();
  }
}
