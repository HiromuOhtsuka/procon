import java.util.Scanner;

public final class Main {
  public static final int MAX_N = 350;
  private int N;
  private int[] score;

  public Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();
    score = new int[N];
    int[] newscore = new int[N];
    score[0] = scan.nextInt();
    for(int i = 2; i <= N; i++){
      int s = scan.nextInt();
      newscore[0] = score[0] + s;

      for(int j = 1; j <= i - 2; j++){
        s = scan.nextInt();
        newscore[j] = max(score[j - 1], score[j]) + s;
      }

      s = scan.nextInt();
      newscore[i - 1] = score[i - 2] + s;

      for(int j = 0; j < N; j++){
        score[j] = newscore[j];
      }
    }
    int max = -1;
    for(int i = 0; i < N; i++){
      if(max < score[i]){
        max = score[i];
      }
    }
    System.out.println(max);
  }

  private int max(int a, int b){
    return a < b ? b : a;
  }

  public static void main(String[] args){
    new Main();
  }
}
