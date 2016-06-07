import java.util.Scanner;

public class Main {
  static String str;
  static int[] s;
  static long[] c;
  static final long M = 1000000007;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    str = sc.next();

    int n = str.length();
    s = new int[n];
    for(int i = 0; i < n; i++){
      char q = str.charAt(i);
      if('0' <= q && q <= '9'){
        s[i] = q - '0';
      }
      else if('A' <= q && q <= 'Z'){
        s[i] = q - 'A' + 10;
      }
      else if('a' <= q && q <= 'z'){
        s[i] = q - 'a' + 36;
      }
      else if(q == '-'){
        s[i] = 62;
      }
      else if(q == '_'){
        s[i] = 63;
      }
    }

    c = new long[64];
    for(int i = 0; i <= 63; i++){
      int count = 6;
      for(int j = 0; j < 6; j++){
        if((i & (1 << j)) != 0){
          --count;
        }
      }
      c[i] = pow(3, count);
    }

    long sum = 1;
    for(int i = 0; i < n; i++){
      sum = (sum * c[s[i]]) % M;
    }

    System.out.println(sum);
  }

  static int pow(int a, int b){
    int ret = 1;
    while(b > 0){
      ret *= a;
      --b;;
    }
    return ret;
  }
}
