import java.util.Scanner;

public class Main{
  static int n;
  static char[] good;
  static char[] pattern;
  static char[][] query;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    good = sc.next().toCharArray();
    pattern = sc.next().toCharArray();
    n = sc.nextInt();
    query = new char[n][];
    for(int i = 0; i < n; i++){
      query[i] = sc.next().toCharArray();
    }

    int asta = -1;
    for(int i = 0; i < pattern.length; i++){
      if(pattern[i] == '*'){
        asta = i;
        break;
      }
    }

    StringBuilder sb = new StringBuilder();
    if(asta == -1){
      for(int i = 0; i < n; i++){
        if(pattern.length != query[i].length){
          sb.append("NO\n");
          continue;
        }
        boolean yes = true;
        for(int j = 0; yes && j < query[i].length; j++){
          if(pattern[j] == '?'){
            if(!isGood(query[i][j])){
              yes = false;
            }
          }
          else{
            if(query[i][j] != pattern[j]){
              yes = false;
            }
          }
        }
        if(yes){
          sb.append("YES\n");
        }
        else{
          sb.append("NO\n");
        }
      }
    }
    else{
      for(int i = 0; i < n; i++){
        if(query[i].length < pattern.length - 1){
          sb.append("NO\n");
          continue;
        }
        boolean yes = true;
        for(int j = 0; yes && j < asta; j++){
          if(pattern[j] == '?'){
            if(!isGood(query[i][j])){
              yes = false;
            }
          }
          else{
            if(query[i][j] != pattern[j]){
              yes = false;
            }
          }
        }
        if(!yes){
          sb.append("NO\n");
          continue;
        }
        int pos = query[i].length - 1;
        for(int j = pattern.length - 1; j > asta; j--){
          if(pattern[j] == '?'){
            if(!isGood(query[i][pos])){
              yes = false;
            }
          }
          else{
            if(query[i][pos] != pattern[j]){
              yes = false;
            }
          }
          --pos;
        }
        if(!yes){
          sb.append("NO\n");
          continue;
        }
        /*
        if(pos - asta + 1 == 1){
          if(isGood(query[i][pos])){
            yes = false;
          }
        }
        else if(pos - asta + 1 >= 2){
          for(int j = asta; j <= pos; j++){
            if(!(!isGood(query[i][j]) && query[i][j] == query[i][j + 1])){
              yes = false;
              break;
            }
          }
        }
        */
        for(int j = asta; j <= pos; j++){
          if(isGood(query[i][j])){
            yes = false;
            break;
          }
        }
        if(yes){
          sb.append("YES\n");
        }
        else{
          sb.append("NO\n");
        }
      }
    }

    System.out.println(sb);
  }

  static boolean isGood(char ch){
    for(int i = 0; i < good.length; i++){
      if(ch == good[i]){
        return true;
      }
    }
    return false;
  }
}
