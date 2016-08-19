import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int[][] A = new int[N][2];
    for(int i = 0; i < N; i++){
      int x = scan.nextInt(), y = scan.nextInt();
      A[i][0] = x;  A[i][1] = y;
    }

  }

  private boolean isCrrossed(double x1, double y1, 
    double x2, double y2){
    return x1 * y2 - y1 * x2 > 0.0;
  }
}
