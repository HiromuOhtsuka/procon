import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static long b1, q, l;
  static int m;
  static long[] a;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    b1 = sc.nextInt();
    q = sc.nextInt();
    l = sc.nextInt();
    m = sc.nextInt();
    a = new long[m];
    for(int i = 0; i < m; i++){
      a[i] = sc.nextInt();
    }

    if(Math.abs(b1) > l){
      System.out.println(0);
      return;
    }

    Set< Long > seqs = new HashSet< >();
    seqs.add(b1);
    long pow = q;
    while(!seqs.contains(b1 * pow) && Math.abs(b1 * pow) <= l){
      seqs.add(b1 * pow);
      pow *= q;
    }

    if(q == 0 || b1 == 0){
      seqs.add(0L);
    }

    for(int i = 0; i < m; i++){
      if(seqs.contains(a[i])){
        seqs.remove(a[i]);
      }
    }

    if(b1 == 0){
      if(seqs.contains(0L)){
        System.out.println("inf");
      }
      else{
        System.out.println(0);
      }
    }
    else if(q == 0){
      if(seqs.contains(0L)){
        System.out.println("inf");
      }
      else{
        System.out.println(seqs.size());
      }
    }
    else if(q == 1){
      if(seqs.contains(b1)){
        System.out.println("inf");
      }
      else{
        System.out.println(0);
      }
    }
    else if(q == -1){
      if(seqs.size() >= 1){
        System.out.println("inf");
      }
      else{
        System.out.println(0);
      }
    }
    else{
      System.out.println(seqs.size());
    }
  }
}
