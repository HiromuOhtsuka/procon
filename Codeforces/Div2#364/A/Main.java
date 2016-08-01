import java.util.Scanner;

public class Main {
  static int n;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += a[i];
    }

    int val = sum / (n / 2);
    boolean[] check = new boolean[n];
    int[] pair = new int[n];
    for(int i = 0; i < n; i++){
      if(!check[i]){
        int tar = val - a[i];
        for(int j = 0; j < n; j++){
          if(i != j && !check[j] && a[j] == tar){
            pair[i] = j;
            check[i] = check[j] = true;
            break;
          }
        }
      }
    }

    for(int i = 0; i < n; i++){
      if(check[i]){
        System.out.println((i + 1) + " " + (pair[i] + 1));
        check[i] = check[pair[i]] = false;
      }
    }
  }
}
