import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int W = scan.nextInt(), H = scan.nextInt(), N = scan.nextInt();
    int x = scan.nextInt() - 1, y = scan.nextInt() - 1;
    int sum = 0;
    for(int i = 1; i < N; i++){
      int nx = scan.nextInt() - 1,  ny = scan.nextInt() - 1;
      if((nx >= x && ny >= y) || (nx <= x && ny <= y)){
        sum += Math.max(Math.abs(nx - x), Math.abs(ny - y));
      }
      else{
        sum += Math.abs(nx - x) + Math.abs(ny - y);
      }
      x = nx; y = ny;
    }

    System.out.println(sum);
  }
}
