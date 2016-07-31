import java.util.Scanner;
import java.util.Arrays;

import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n, k;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    s = sc.next();

    char[] ss = s.toCharArray();
    Arrays.sort(ss);

    char[] ans = new char[n];
    char[] tmp = new char[n];
    int sp = 0;
    boolean[] sscheck = new boolean[n];
    boolean ok = false;
    while(!ok){
      ok = true;
      for(int i = 0; i < n; i++){
        if(sscheck[i]){
          continue;
        }
        tmp[sp] = ss[i];
        for(int j = sp + 1; j < n; j++){
          tmp[j] = '\0';
        }
        char[] set = new char[n];
        int w = 0;
        boolean[] wcheck = new boolean[n];
        for(int j = 0; j < n; j++){
          boolean flag = false;
          for(int k = 0; k <= sp; k++){
            if(!wcheck[k] && tmp[k] == ss[j]){
              flag = true;
              wcheck[k] = true;
              break;
            }
          }
          if(!flag){
            set[w++] = ss[j];
          }
        }
        boolean[] check = new boolean[n];
        for(int j = sp + 1; j < n; j++){
          for(int k = 0; k < w; k++){
            if(!check[k] && set[k] == s.charAt(j)){
              tmp[j] = s.charAt(j);
              check[k] = true;
              break;
            }
          }
        }
        for(int j = sp + 1; j < n; j++){
          if(tmp[j] == '\0'){
            for(int k = sp + 1; k < n; k++){
              if(!check[k]){
                tmp[j] = set[k];
                check[k] = true;
                break;
              }
            }
          }
        }
        int diff = 0;
        for(int j = 0; j < n; j++){
          if(tmp[j] != s.charAt(j)){
            ++diff;
          }
        }
        if(diff <= k){
          sp++;
          sscheck[i] = true;
          ok = false;
          for(int j = 0; j < n; j++){
            ans[j] = tmp[j];
          }
          break;
        }
      }
    }

    System.out.println(ans);
  }
}
