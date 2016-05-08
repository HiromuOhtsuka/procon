import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    for(;;){
      // input
      int n, q;
      n = scan.nextInt(); q = scan.nextInt();
      if(n == 0 && q == 0){
        break;
      }
      boolean[][] table = new boolean[n][128];  // less than 100
      // initialize
      for(int i=0; i<table.length; i++){
        for(int j=0; j<table[0].length; j++){
          table[i][j] = false;
        }
      }
      // input
      for(int i=0; i<n; i++){
        int m = scan.nextInt();
        for(int j=0; j<m; j++){
          int date = scan.nextInt();
          table[i][date] = true;
        }
      }
      // search
      int maxCount = 0;
      int bestDate = 0;
      for(int i=0; i<table[0].length; i++){
        int count = 0;
        for(int j=0; j<n; j++){
          if(table[j][i]){
            count++;
            if(count > maxCount){
              maxCount = count;
              bestDate = i;
            }
          }
        }
      }
      if(maxCount < q){
        System.out.println("0");
      }
      else{
        System.out.println(bestDate);
      }
    }
  }
}
