import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n, k;
  static String[] s;

  static int c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    s = new String[n - k + 1];
    for(int i = 0; i < n - k + 1; i++){
      s[i] = sc.next();
    }

    String[] sol = new String[n];
    for(int i = 0; i < n - k + 1; i++){
      if(s[i].equals("YES")){
        for(int j = 0; j < k; j++){
          if(sol[i + j] == null){
            sol[i + j] = uniqueString();
          }
        }
      }
    }

    for(int i = 0; i < n - k + 1; i++){
      if(s[i].equals("NO")){
        if(sol[i] == null){
          sol[i] = uniqueString();
        }
        sol[i + k - 1] = sol[i];
      }
    }

    for(int i = 0; i < n; i++){
      if(sol[i] == null){
        sol[i] = uniqueString();
      }
    }

    //if(!check(sol)){
      //System.out.println("invalid");
    //}

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < n; i++){
      sb.append(sol[i] + " ");
    }

    System.out.println(sb);
  }

  private static String uniqueString(){
    StringBuilder sb = new StringBuilder();
    sb.append((char)('A' + (c / 26)));
    sb.append((char)('a' + (c % 26)));
    ++c;
    return sb.toString();
  }

  private static boolean check(String[] sol){
    for(int i = 0; i < n - k + 1; i++){
      Set< String > set = new HashSet< >();
      for(int j = 0; j < k; j++){
        set.add(sol[i + j]);
      }
      if(s[i].equals("YES")){
        if(set.size() != k){
          return false;
        }
      }
      else{
        if(set.size() == k){
          return false;
        }
      }
    }
    return true;
  }
}
