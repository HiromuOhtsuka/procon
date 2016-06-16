import java.util.Scanner;

public class Main {
  static int k, n;
  static int[] v;
  static String[] w;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    k = sc.nextInt(); n = sc.nextInt();
    v = new int[n]; w = new String[n];
    for(int i = 0; i < n; i++){
      v[i] = sc.nextInt();  w[i] = sc.next();
    }

    len = new int[k + 1];
    search(1);
  }

  static int[] len;
  static boolean flag;
  private static void search(int i){
    if(flag){
      return;
    }
    if(i == k + 1){
      String[] map = new String[k + 1];
      for(int j = 0; j < n; j++){
        int value = v[j], last = w[j].length();
        while(value != 0){
          int t = value % 10;
          if(last - len[t] < 0){
            return;
          }
          if(map[t] == null){
            map[t] = w[j].substring(last - len[t], last);
          }
          last -= len[t];
          value /= 10;
        }
      }

      if(check(map)){
        for(int j = 1; j <= k; j++){
          System.out.println(map[j]);
        }
        flag = true;
      }
      return;
    }
    for(int j = 1; j <= 3; j++){
      len[i] = j;
      search(i + 1);
    }
  }

  private static boolean check(String[] map){
    for(int i = 0; i < n; i++){
      int value = v[i], last = w[i].length();
      while(value != 0){
        int t = value % 10;
        if(last - len[t] < 0){
          return false;
        }
        String sub = w[i].substring(last - len[t], last);
        if(!sub.equals(map[t])){
          return false;
        }
        last -= len[t];
        value /= 10;
      }
      if(last != 0){
        return false;
      }
    }
    return true;
  }
}
