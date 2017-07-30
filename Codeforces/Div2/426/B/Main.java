import java.util.Scanner;

public class Main{
  static int n, k;
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();
    s = sc.next().toCharArray();
    int[] a = new int[n];
    for(char ch = 'A'; ch <= 'Z'; ch++){
      int end = -1;
      for(int i = s.length - 1; i >= 0; i--){
        if(ch == s[i]){
          end = i;
          break;
        }
      }
      int start = -1;
      for(int i = 0; i < s.length; i++){
        if(ch == s[i]){
          start = i;
          break;
        }
      }
      if(start != -1 && end != -1){
        if(start != end){
          a[start] = 1;
          a[end] = 2;
        }
        else{
          a[start] = 3;
        }
      }
    }

    int r = k;
    boolean yes = false;
    for(int i = 0; i < n; i++){
      if(a[i] == 1){
        --r;
      }
      if(a[i] == 2){
        ++r;
      }
      if(a[i] == 3){
        --r;
      }
      if(r < 0){
        yes = true;
        break;
      }
      if(a[i] == 3){
        ++r;
      }
    }

    if(yes){
      System.out.println("YES");
    }
    else{
      System.out.println("NO");
    }
  }
}
