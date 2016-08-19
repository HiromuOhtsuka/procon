import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(), A = scan.nextInt(), B = scan.nextInt();
    int ans = 1;
    if(B >= 0){
      ans = (A + B) % N;
    }
    else{
      B = -B % N;
      ans = (A - B + N) % N;
    }
    if(ans == 0){
      ans = N;
    }

    System.out.println(ans);
  }
}
