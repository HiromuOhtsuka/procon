import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      int R = scan.nextInt(), N = scan.nextInt();

      if(R == -1 && N == -1){
        break;
      }

      int[] X = new int[N];
      for(int i = 0; i < N; i++){
        X[i] = scan.nextInt();
      }

      Arrays.sort(X);
      int i = 0, count = 0;
      while(i < N){
        int l = X[i++];
        while(i < N && l + R >= X[i]) i++;
        int m = X[i - 1];
        while(i < N && m + R >= X[i]) i++;
        ++count;
      }

      System.out.println(count);
    }
  }
}

