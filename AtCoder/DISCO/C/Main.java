import java.util.Scanner;
import java.util.Arrays;

public class Main{
  static int n;
  static int c;
  static int[] l;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    c = sc.nextInt();
    l = new int[n];
    for(int i = 0; i < n; i++){
      l[i] = sc.nextInt();
    }

    Arrays.sort(l);
    int count = 0;
    int i = 0;
    for(int j = l.length - 1; j >= i; j--){
      if(l[i] + l[j] + 1 <= c){
        i++;
      }
      ++count;
    }

    System.out.println(count);
  }
}
