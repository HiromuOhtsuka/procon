import java.util.Scanner;

public class Main {
  static int n, t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); t = sc.nextInt();
    double[][] cup = new double[n + 1][n + 1];

    cup[0][0] = t;
    for(int i = 0; i < n; i++){
      for(int j = 0; j <= i; j++){
        cup[i + 1][j] += Math.max(0.0, (cup[i][j] - 1.0) / 2.0);
        cup[i + 1][j + 1] += Math.max(0.0, (cup[i][j] - 1.0) / 2.0);
      }
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      for(int j = 0; j <= i; j++){
        if(cup[i][j] >= 1.0){
          ++count;
        }
      }
    }

    System.out.println(count);
  }
}
