import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main{
  static int n, k;
  static int[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    a = new int[k];
    for(int i = 0; i < k; i++){
      a[i] = sc.nextInt();
    }

    List< Integer > list = new ArrayList< >();
    for(int i = 0; i < n; i++){
      list.add(i + 1);
    }
    StringBuilder sb = new StringBuilder();
    int leader = 0;
    for(int i = 0; i < k; i++){
      leader = (leader + a[i]) % list.size();
      sb.append(list.get(leader) + " ");
      list.remove(leader);
    }

    System.out.println(sb);
  }
}
