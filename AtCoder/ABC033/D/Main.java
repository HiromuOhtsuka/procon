import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    int[] X = new int[N], Y = new int[N];
    for(int i = 0; i < N; i++){
      int x = scan.nextInt(), y = scan.nextInt();
      X[i] = x; Y[i] = y;
    }
    
    int ei = 0, tyo = 0, don = 0;
    for(int i = 0; i < N; i++){
      for(int j = i + 1; j < N; j++){
        for(int k = j + 1; k < N; k++){
          int val1 = dot(X[j] - X[i], Y[j] - Y[i], X[k] - X[i], Y[k] - Y[i]);
          int val2 = dot(X[j] - X[k], Y[j] - Y[k], X[i] - X[k], Y[i] - Y[k]);
          int val3 = dot(X[i] - X[j], Y[i] - Y[j], X[k] - X[j], Y[k] - Y[j]);
          if(val1 < 0 || val2 < 0 || val3 < 0){
            don++;
          }
          else if(val1 == 0 || val2 == 0 || val3 == 0){
            tyo++;
          }
          else{
            ei++;
          }
        }
      }
    }

    System.out.println(ei + " " + tyo + " " + don);
  }

  static int dot(int x1, int y1, int x2, int y2){
    return x1 * x2 + y1 * y2;
  }
}
