import java.util.Scanner;

public class Sub {
  static int n;
  static int[] c;

  static int[] perm;
  static boolean[] used;

  static long sum;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    c = new int[n];
    for(int i = 0; i < n; i++){
      c[i] = sc.nextInt();
    }

    perm = new int[n];
    used = new boolean[n];
    permutation(0);

    long kai = 1;
    for(long i = 1; i <= n; i++){
      kai *= i;
    }

    double ex = (double)sum / (double)kai;

    System.out.println(ex);
  }

  private static void permutation(int i){
    if(i == n){
      sum += count();
      return;
    }
    for(int j = 0; j < n; j++){
      if(!used[j]){
        perm[i] = j;
        used[j] = true;
        permutation(i + 1);
        used[j] = false;
      }
    }
  }

  private static long count(){
    boolean[] table = new boolean[n];
    for(int i = 0; i < n; i++){
      for(int j = i + 1; j < n; j++){
        if(c[perm[j]] % c[perm[i]] == 0){
          table[j] = !table[j];
        }
      }
    }

    long cc = 0;
    for(int i = 0; i < n; i++){
      if(!table[i]){
        ++cc;
      }
    }

    return cc;
  }
}
