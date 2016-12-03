import java.util.Scanner;

public class Main {
  static int n, a, b, k;
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();
    k = sc.nextInt();
    str = sc.next().toCharArray();

    int count = 0, s = 0;
    while(s < n && str[s] == '0'){
      ++s;
    }
    count += s / b;
    while(s < n){
      int t = s + 1;
      while(t < n && str[t] == '0'){
        ++t;
      }
      count += (t - s - 1) / b;
      s = t;
    }

    int[] ans = new int[n];
    int sp = 0;
    s = 0;
    while(count > a - 1 && s < n){
      while(s < n && str[s] == '1'){
        ++s;
      }
      boolean flag = true;
      for(int t = s; t < s + b; t++){
        if(str[t] != '0'){
          flag = false;
          s = t + 1;
          break;
        }
      }
      if(flag){
        ans[sp++] = s + b;
        --count;
        s += b;
      }
    }

    StringBuilder sb = new StringBuilder();
    sb.append(sp + System.lineSeparator());
    for(int i = 0; i < sp; i++){
      sb.append(ans[i] + ((i == sp - 1 ? System.lineSeparator() : " ")));
    }

    System.out.print(sb);
  }
}
