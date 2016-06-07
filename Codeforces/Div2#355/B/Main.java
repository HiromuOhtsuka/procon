import java.util.Scanner;

public class Main {
  static int n, h, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // input
    n = sc.nextInt(); h = sc.nextInt(); k = sc.nextInt();
    a = new int[n];
    for(int i = 0; i < n; i++){
      a[i] = sc.nextInt();
    }

    long sec = 0;
    long sum = 0;
    int i = 0;
    while(i < n){
      while(i < n && sum + a[i] <= h){
        sum += a[i];
        ++i;
      }
      int c = (int)sum / k;
      if(c != 0){
        sum -= k * c;
        sec += c - 1;
        ++sec;
      }
      else{
        sum = 0;
        ++sec;
      }
    }

    if(sum != 0){
      ++sec;
    }

    System.out.println(sec);
  }
}
