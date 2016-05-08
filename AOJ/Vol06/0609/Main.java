import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(), M = sc.nextInt();
    int[] target = new int[M];
    for(int i = 0; i < M; i++){
      target[i] = sc.nextInt() - 1;
    }
    int[] score = new int[N];
    for(int i = 0; i < M; i++){
      int x = 0;
      for(int j = 0; j < N; j++){
        int b = sc.nextInt() - 1;
        if(target[i] != b){
          ++x;
        }
        else{
          ++score[j];
        }
      }
      score[target[i]] += x;
    }

    for(int i = 0; i < N; i++){
      System.out.println(score[i]);
    }
  }
}
