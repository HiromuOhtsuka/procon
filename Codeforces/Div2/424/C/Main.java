import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int k, n;
  static int[] a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    k = sc.nextInt();
    n = sc.nextInt();
    a = new int[k];
    for(int i = 0; i < k; i++){
      a[i] = sc.nextInt();
    }
    b = new int[n];
    for(int i = 0; i < n; i++){
      b[i] = sc.nextInt();
    }

    Set< Integer > cands = new HashSet< >();
    int s = 0;
    for(int i = 0; i < k; i++){
      s += a[i];
      cands.add(b[0] - s);
    }

    int count = 0;
    for(Integer i : cands){
      int sum = i;
      Set< Integer > exist = new HashSet< >();
      for(int j = 0; j < k; j++){
        sum += a[j];
        exist.add(sum);
      }
      boolean check = true;
      for(int j = 0; j < n; j++){
        if(!exist.contains(b[j])){
          check = false;
          break;
        }
      }
      if(check){
        ++count;
      }
    }

    System.out.println(count);
  }
}
