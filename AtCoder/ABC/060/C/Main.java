import java.util.Scanner;

public class Main{
  static int n;
  static long s;
  static long[] t;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.nextInt();
    t = new long[n];
    for(int i = 0; i < n; i++){
      t[i] = sc.nextInt();
    }

    long sum = 0;
    long time = t[0];
    for(int i = 0; i < n; i++){
      if(t[i] >= time){
        sum += s;
      }
      else{
        sum += (t[i] + s) - time;
      }
      time = t[i] + s;
    }

    System.out.println(sum);
  }
}
