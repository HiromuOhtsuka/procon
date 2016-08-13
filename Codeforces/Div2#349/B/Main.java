import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] l;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    l = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt();
    }

    Arrays.sort(l);
    long s1 = l[n - 1], s2 = l[n - 2];
    for(int i = n -  3; i >= 0; i--){
      if(s1 >= s2){
        s2 += l[i];
      }
      else{
        s1 += l[i];
      }
    }

    long ans = Math.abs(s1 - s2) + 1;

    System.out.println(ans);
  }
}
