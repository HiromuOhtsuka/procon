import java.util.Scanner;
import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Main {
  static int n;
  static char[] a;
  static int[] b;
  static Map< Character, List< Edge > > G;

  static boolean[] used;
  static char[] str;
  static Set< String > set;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    while(sc.hasNextLine()){
      String line = sc.nextLine();

      if(line.length() == 0){
        continue;
      }

      n = 0;
      a = new char[128];
      b = new int[128];
      for(int i = 0; i < line.length(); i += 2){
        char ch = line.charAt(i);
        a[n] = ch;
        b[ch - 'a'] = n;
        ++n;
      }

      line = sc.nextLine();
      G = new TreeMap< Character, List< Edge > >();
      for(int i = 0; i < n; i++){
        G.put(a[i], new ArrayList< Edge >());
      }
      for(int i = 0; i < line.length(); i += 4){
        char v = line.charAt(i), w = line.charAt(i + 2);
        List< Edge > list = G.get(w);
        list.add(new Edge(w, v));
      }

      used = new boolean[n];
      str = new char[n];
      set = new TreeSet< String >();
      backTrack(0);

      for(String s : set){
        System.out.println(s);
      }

      System.out.println();
    }
  }

  private static void backTrack(int i){
    if(i == n){
      set.add(new String(str));
      return;
    }

    for(int j = 0; j < n; j++){
      if(!used[j]){
        boolean flag = true;
        for(int k = 0; k < G.get(a[j]).size(); k++){
          char w = G.get(a[j]).get(k).w;
          if(!used[b[w - 'a']]){
            flag = false;
            break;
          }
        }
        if(flag){
          used[j] = true;
          str[i] = a[j];
          backTrack(i + 1);
          used[j] = false;
        }
      }
    }
  }

  static class Edge {
    char v, w;

    Edge(char v, char w){
      this.v = v; this.w = w;
    }
  }
}
