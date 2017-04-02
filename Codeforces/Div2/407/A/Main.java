import java.util.Scanner;

public class Main{
  static int n, k;
  static int[] w;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    w = new int[n];
    for(int i = 0; i < n; i++){
      w[i] = sc.nextInt();
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(w[i] % k == 0){
        count += w[i] / k;
      }
      else{
        count += w[i] / k + 1;
      }
    }

    if(count % 2 == 0){
      count /= 2;
    }
    else{
      count = count / 2 + 1;
    }

    System.out.println(count);
  }
}
