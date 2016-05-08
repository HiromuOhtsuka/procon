import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt();
    char[] reader = new char[N];
    sc.nextLine();
    String line = sc.nextLine();
    for(int i = 0; i < N; i++){
      reader[i] = line.charAt(i);
    }

    int[][] dp = new int[N][8];
    int r = 1;
    if(reader[0] == 'O'){
      r = 2;
    }
    else if(reader[0] == 'I'){
      r = 4;
    }
    for(int s = 0; s < 8; s++){
      if((s & 1) > 0 && (s & r) > 0){
        dp[0][s] = 1;
      }
    }

    for(int i = 1; i < N; i++){
      r = 1;
      if(reader[i] == 'O'){
        r = 2;
      }
      else if(reader[i] == 'I'){
        r = 4;
      }
      for(int s = 0; s < 8; s++){
        if((s & r) > 0){
          for(int sub = 0; sub < 8; sub++){
            if((sub & s) > 0){
              dp[i][s] = (dp[i][s] + dp[i - 1][sub]) % 10007;
            }
          }
        }
      }
    }

    int sum = 0;
    for(int s = 0; s < 8; s++){
      sum = (sum + dp[N - 1][s]) % 10007;
    }

    System.out.println(sum);
  }
}
