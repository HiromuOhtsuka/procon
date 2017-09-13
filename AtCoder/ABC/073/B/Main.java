import java.util.Scanner;

public class Main{
  static final int MAX = 100000;
  static int n;
  static int[] l, r;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l = new int[n];
    r = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt() - 1;
      r[i] = sc.nextInt() - 1;
    }

    int[] seat = new int[MAX + 1];
    for(int i = 0; i < n; i++){
      seat[l[i]]++;
      seat[r[i] + 1]--;
    }

    int sum = 0;
    int status = 0;
    for(int i = 0; i < MAX; i++){
      status += seat[i];
      if(status > 0){
        ++sum;
      }
    }

    System.out.println(sum);
  }
}
