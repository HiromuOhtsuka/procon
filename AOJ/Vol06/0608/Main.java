import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int A = sc.nextInt(), B = sc.nextInt(),
      C = sc.nextInt(), D = sc.nextInt(), P = sc.nextInt();

    int X = A * P, Y = B;
    if(P - C > 0){
      Y += (P - C) * D;
    }

    if(X < Y){
      System.out.println(X);
    }
    else{
      System.out.println(Y);
    }
  }
}
