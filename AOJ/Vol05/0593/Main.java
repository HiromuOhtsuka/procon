import java.util.Scanner;

public class Main {
  int N, M;
  int[] A, B;

  Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt(); M = scan.nextInt();
    A = new int[N]; B = new int[M];
    for(int i = 0; i < N; i++){
      A[i] = scan.nextInt();
    }
    for(int i = 0; i < M; i++){
      B[i] = scan.nextInt();
    }

    int[] count = new int[N];
    for(int i = 0; i < M; i++){
      for(int j = 0; j < N; j++){
        if(A[j] <= B[i]){
          count[j]++;
          break;
        }
      }
    }

    int mx = 0, mxi = 0;
    for(int i = 0; i < N; i++){
      if(mx < count[i]){
        mxi = i;
        mx = count[i];
      }
    }

    System.out.println(mxi + 1);
  }

  public static void main(String[] args){
    new Main();
  }

}
