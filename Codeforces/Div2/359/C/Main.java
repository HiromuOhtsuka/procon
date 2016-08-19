import java.util.Scanner;

public class Main {
  static int n, m;
  static boolean[] used;
  static int[] perm;
  static int nk, mk;
  static int count;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); m = sc.nextInt();

    nk = 0; mk = 0;
    int tmp = n - 1;
    while(tmp != 0){
      tmp /= 7;
      ++nk;
    }
    tmp = m - 1;
    while(tmp != 0){
      tmp /= 7;
      ++mk;
    }

    if(n == 1){
      nk = 1;
    }
    if(m == 1){
      mk = 1;
    }

/*
    System.out.println("nk:" + nk);
    System.out.println("mk:" + mk);
*/


    if(nk + mk > 7){
      System.out.println(0);
      return;
    }

    used = new boolean[7];
    perm = new int[nk + mk];
    backTrack(0, 0, 0, nk + mk);

    System.out.println(count);
  }

  private static void backTrack(int i, int val1, int val2, int c){
    if(val1 >= n || val2 >= m){
      return;
    }

    if(i == c){
      // debug
      /*
      for(int j = 0; j < c; j++){
        System.out.print(" " + perm[j]);
      }
      System.out.println();

      System.out.println("val1:" + val1);
      System.out.println("val2:" + val2);
      */

      ++count;
      return;
    }

    for(int j = 0; j < 7; j++){
      if(!used[j]){
        used[j] = true;
        perm[i] = j;
        if(i < nk){
          backTrack(i + 1, val1 + pow(7, i) * j, val2, c);
        }
        else{
          backTrack(i + 1, val1, val2 + pow(7, i - nk) * j, c);
        }
        used[j] = false;
      }
    }
  }

  private static int pow(int a, int b){
    int ret = 1;
    while(b != 0){
      ret *= a;
      --b;
    }
    return ret;
  }
}
