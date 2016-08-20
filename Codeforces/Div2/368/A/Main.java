import java.util.Scanner;

public class Main {
  static int n, m;
  static char[][] p;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();
    p = new char[n][m];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        p[i][j] = sc.next().charAt(0);
      }
    }

    boolean bw = true;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < m; j++){
        switch(p[i][j]){
          case 'C': case 'M': case 'Y':
            bw = false; break;
        }
        if(!bw){
          break;
        }
      }
    }

    if(bw){
      System.out.println("#Black&White");
    }
    else{
      System.out.println("#Color");
    }
  }
}
