import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      int n = scan.nextInt();
      if(n == 0) break;
      int w, h;
      w = scan.nextInt(); h = scan.nextInt();
      boolean[][] table = new boolean[h+1][w+1];
      for(int i=0; i<table.length; i++){
        for(int j=0; j<table[0].length; j++){
          table[i][j] = false;
        }
      }
      for(int i=0; i<n; i++){
        int x, y;
        x = scan.nextInt(); y = scan.nextInt();
        table[y][x] = true;
      }
      int s, t;
      s = scan.nextInt(); t = scan.nextInt();

      int count = 0;
      /* 回数と実際の数値を考えよ．*/
      for(int i=1; i<=w-s+1; i++){
        for(int j=1; j<=h-t+1; j++){
          int subCount = 0;
          for(int k=i; k<i+s; k++){
            for(int l=j; l<j+t; l++){
              if(table[l][k]){
                subCount++;
              }
            }
          }
          if(subCount > count){
            count = subCount;
          }
        }
      }

      System.out.println(count);
    }
  }
}
