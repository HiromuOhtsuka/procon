import java.util.Scanner;

public class Main {
  static int n;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();

    for(int i = 1; i <= 9; i++){
      for(int j = 1; j <= 9; j++){
        int sum = 0;
        for(int k = 1; k <= 9; k++){
          for(int l = 1; l <= 9; l++){
            if(k == i && l == j){
              continue;
            }
            sum += k * l;
          }
        }
        if(sum == n){
          System.out.println(i + " x " + j);
        }
      }
    }
  }
}
