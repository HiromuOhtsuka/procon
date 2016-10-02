import java.util.Scanner;

public class Main {
  static int n, t;
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); t = sc.nextInt();
    s = sc.next();

    char[] str = s.toCharArray();
    int dp = 0;
    while(dp < n && str[dp] != '.'){
      ++dp;
    }

    int pos = -1;
    for(int i = dp + 1; i < n; i++){
      if(str[i] - '5' >= 0){
        pos = i; break;
      }
    }

    if(pos == -1){
      System.out.println(s);
      return;
    }

    int last = pos;
    StringBuilder pre = new StringBuilder();
    while(t > 0 && str[pos] - '5' >= 0){
      if(str[pos - 1] == '.'){
        if(str[pos - 2] != '9'){
          str[pos - 2]++;
        }
        else{
          pos = pos - 2;
          while(pos >= 0 && str[pos] == '9'){
            str[pos] = '0';
            --pos;
          }
          if(pos >= 0){
            ++str[pos];
          }
          else{
            pre.append(1);
          }
        }
        --pos; --t;
        last = dp;
        break;
      }
      else{
        ++str[pos - 1];
        last = pos;
        --pos;  --t;
      }
    }

    System.out.println(pre.toString() + (new String(str, 0, last)));
  }
}
