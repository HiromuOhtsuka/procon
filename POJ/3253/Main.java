import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int[] L = new int[N];
    for(int i = 0; i < N; i++){
      L[i] = scan.nextInt();
    }

    long cost = 0;
    while(N > 1){
      int m1 = 0, m2 = 1;
      if(L[m1] > L[m2]){
        int w = m1;
        m1 = m2;
        m2 = w;
      }
      for(int i = 2; i < N; i++){
        if(L[i] < L[m1]){
          m2 = m1;
          m1 = i;
        }
        else if(L[i] < L[m2]){
          m2 = i;
        }
      }
      int tmp = L[m1] + L[m2];
      cost += tmp;
      if(m1 == N - 1){
        int w = m1;
        m1 = m2;
        m2 = w;
      }
      L[m1] = tmp; L[m2] = L[N - 1];
      --N;
    }

    System.out.println(cost);

  }
}

