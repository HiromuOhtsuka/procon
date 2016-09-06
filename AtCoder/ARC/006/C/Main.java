import java.util.Scanner;

public class Main {
  static final int INF = Integer.MAX_VALUE / 2;
  static int n;
  static int[] w;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    w = new int[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.nextInt();
    }

    int[][] stack = new int[n][n];
    int[] sp = new int[n];
    int count = 0;
    for(int i = 0; i < n; i++){
      int next = -1, diff = INF;
      for(int j = 0; j < count; j++){
        if(stack[j][sp[j] - 1] >= w[i]){
          int d = stack[j][sp[j] - 1] - w[i];
          if(d < diff){
            diff = d; next = j;
          }
        }
      }
      if(next != -1){
        stack[next][sp[next]++] = w[i];
      }
      else{
        stack[count][sp[count]++] = w[i];
        ++count;
      }
    }

    System.out.println(count);
  }
}
