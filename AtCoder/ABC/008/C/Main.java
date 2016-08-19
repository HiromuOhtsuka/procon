import java.util.Scanner;

public class Main {
  static int n;
  static int[] c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
    }

    double ex = 0.0;
    for(int i = 0; i < n; i++){
      int count = 0;
      for(int j = 0; j < n; j++){
        if(i != j && c[i] % c[j] == 0){
          ++count;
        }
      }
      if(count % 2 == 0){
        ex += (double)(count + 2.0) / (2.0 * (double)count + 2.0);
      }
      else{
        ex += 1.0 / 2.0;
      }
    }

    System.out.println(ex);
  }
}
