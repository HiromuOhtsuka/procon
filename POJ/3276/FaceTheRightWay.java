import java.util.Scanner;

public class Main {
  static final int MAX_N = 5555;
  static int N;
  static int[] a = new int[MAX_N];
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();
    scan.nextLine();
    for(int i = 0; i < N; i++){
      String s = scan.nextLine();
      if(s.equals("B")){
        a[i] = 1;
      }
    }

    int bestK = 1, bestM = N;
    for(int k = 1; k <= N; k++){
      int m = search(k);
      if(m != -1 && bestM > m){
        bestM = m;  bestK = k;
      }
    }

    System.out.println(bestK + " " + bestM);
  }

  static int search(int k){
    int count = 0, sum = 0;
    int[] f = new int[N];
    for(int i = 0; i + k <= N; i++){
      if(((sum + a[i]) % 2) == 1){
        ++count;
        f[i] = 1;
      }
      sum += f[i];
      if(i - k + 1 >= 0){
        sum -= f[i - k + 1];
      }
    }

    for(int i = N - k + 1; i < N; i++){
      if(((sum + a[i]) % 2) == 1){
        return -1;
      }
      if(i - k + 1 >= 0){
        sum -= f[i - k + 1];
      }
    }

    return count;
  }
}
