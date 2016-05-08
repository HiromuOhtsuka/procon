import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
  static int n;
  static int[] used;
  static int[] perm;
  static Set< String > set;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    sc.nextLine();

    perm = new int[13];
    used = new int[13];
    set = new TreeSet< String >(
        new Comparator< String >(){
        @Override
        public int compare(String s1, String s2){
        char[] cc1 = s1.toCharArray(), cc2 = s2.toCharArray();
        for(int i = 0; i < cc1.length; i++){
        char c1 = cc1[i], c2 = cc2[i];
        if(('a' <= c1 && c1 <= 'z') &&
          ('a' <= c2 && c2 <= 'z')){
        if(c1 < c2){
        return -1;
        }
        else if(c1 > c2){
        return 1;
        }
        }
        else if(('A' <= c1 && c1 <= 'Z') &&
          ('A' <= c2 && c2 <= 'Z')){
        if(c1 < c2){
        return -1;
        }
        else if(c1 > c2){
          return 1;
        }
        }
        else if(('a' <= c1 && c1 <= 'z') &&
            ('A' <= c2 && c2 <= 'Z')){
          c2 = (char)('a' + c2 - 'A');
          if(c1 < c2){
            return -1;
          }
          else if(c1 > c2){
            return 1;
          }
          else{
            return 1;
          }
        }
        else{
          c1 = (char)('a' + c1 - 'A');
          if(c1 < c2){
            return -1;
          }
          else if(c1 > c2){
            return 1;
          }
          else{
            return -1;
          }
        }
        }
        return 0;
        };
        }

    );
    for(int i = 0; i < n; i++){
      String str = sc.nextLine();
      Character[] chs = str.toCharArray();
      for(int j = 0; j < str.length(); j++){
        if(used[j] == -1){
          continue;
        }
        for(int k = j + 1; k < str.length(); k++){
          if(j != k && str.charAt(j) == str.charAt(k)){
            ++used[j]; used[k] = -1;
          }
        }
      }
      search(str.toCharArray(), 0, str.length());
      for(String s : set){
        System.out.println(s);
      }
      set.clear();
    }
  }

  private static void search(char[] str, int i, int len){
    if(i == len){
      char[] tmp = new char[len];
      for(int j = 0; j < len; j++){
        tmp[j] = str[perm[j]];
      }
      set.add(new String(tmp));
      return;
    }
    for(int j = 0; j < len; j++){
      if(used[j] >= 0){
        --used[j];
        perm[i] = j;
        search(str, i + 1, len);
        ++used[j];
      }
    }
  }
}

