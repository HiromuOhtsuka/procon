import java.util.Scanner;

public class Main {
  static final int J = 2, O = 1, I = 0;

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    scan.nextLine();
    String str = scan.nextLine();

    int[][] dp = new int[N][8];

    if(str.charAt(0) == 'J'){
      for(int j = 0; j < (1 << J) - 1; j++){
        dp[0][(1 << J) | j] = 1;
      }
    }
    else{
      int s = O;
      if(str.charAt(0) == 'I'){
        s = I;
      }
      for(int j = 0; j < (1 << J) - 1; j++){
        dp[0][(1 << J) | j | (1 << s)] = 1;
      }
    }

    for(int i = 1; i < N; i++){
      int s = 'J';
      if(str.charAt(i) == 'O'){
        s = O;
      }
      else{
        s = I;
      }
      for(int j = 0; j < 8; j++){
        dp[i][~(1 << s) & j] = 0;
      }
      for(int j = 0; j < 8; j++){
        int b = (1 << s) | j, sum = 0;
        int sub = b;
        do{
          sum = (sum + dp[i - 1][sub]) % 10007;
          sub = (sub - 1) & sub;
        } while(sub != (1 << s));
        dp[i][b] = sum;
      }
    }

    int ans = 0;
    for(int j = 0; j < 8; j++){
      ans = (ans + dp[N - 1][j]) % 10007;
    }

    System.out.println(ans);
  }
}
