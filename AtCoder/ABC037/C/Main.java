import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    int N = sc.nextInt(), K = sc.nextInt();
    int[] a = new int[N];
    for(int i = 0; i < N; i++){
      a[i] = sc.nextInt();
    }

    long sub = 0;
    for(int i = 0; i < K; i++){
      sub += a[i];
    }
    long sum = sub;
    for(int i = K; i < N; i++){
      sub -= a[i - K];
      sub += a[i];
      sum += sub;
    }

    System.out.println(sum);
  }
}
