import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

    List< Integer > list = new ArrayList< Integer >();
    for(int i = 0; i < n - 1; i++){
      if(GCD(a[i], a[i + 1]) == 1){
        list.add(a[i]);
      }
      else{
        list.add(a[i]); list.add(1);
      }
    }
    list.add(a[n - 1]);

    int k = list.size() - n;
    System.out.println(k);
    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i) + ((i == list.size() - 1) ? "\n" : " "));
    }
  }

  private static int GCD(int a, int b){
    if(a == 0){
      return b;
    }
    return GCD(b % a, a);
  }
}
