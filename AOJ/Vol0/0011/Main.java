import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    // ready
    Scanner scan = new Scanner(System.in);
    int w, n;
    int[][] table;
    int[] outcome;
    w = scan.nextInt();
    n = scan.nextInt();
    table = new int[n+1][w+1];
    outcome = new int[w+1];
    for(int i=0; i<=n; i++){
      for(int j=0; j<=w; j++){
        table[i][j] = j;
      }
    }
    // input
    for(int i=1; i<=n; i++){
      String line = scan.next();
      String[] el;
      el = line.split(",", 0);
      int a, b;
      a = Integer.parseInt(el[0]);
      b = Integer.parseInt(el[1]);
      table[i][a] = b; table[i][b] = a;
    }
    // search
    for(int i=1; i<=w; i++){
      int line = i;
      for(int j=1; j<=n; j++){
        line = table[j][line];
      }
      outcome[line] = i;
    }
    // outcome
    for(int i=1; i<=w; i++){
      System.out.println(outcome[i]);
    }
  }
}


