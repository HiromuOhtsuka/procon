import java.util.Scanner;

public class Main {
  static int n, k;
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    str = sc.next().toCharArray();

    int g = -1, t = -1;
    for(int i = 0; i < n; i++){
      if(str[i] == 'G'){
        g = i;
      }
      if(str[i] == 'T'){
        t = i;
      }
    }

    boolean ans = false;
    if(Math.abs(g - t) % k == 0){
      if(g < t){
        int p = g;
        while(p < t && str[p] != '#'){
          p += k;
        }
        if(str[p] == 'T'){
          ans = true;
        }
      }
      else{
        int p = g;
        while(p > t && str[p] != '#'){
          p -= k;
        }
        if(str[p] == 'T'){
          ans = true;
        }
      }
    }

    if(ans){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
