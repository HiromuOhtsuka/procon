import java.util.Scanner;

public class Main{
  static int n, k;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    k = sc.nextInt();

    int div = 1;
    for(int i = 0; i < k; i++){
      div *= 10;
    }

    char[] number = Integer.toString(n).toCharArray();
    int len = number.length;

    int min = len;
    for(int s = 0; s < (1 << len) - 1; s++){
      StringBuilder sb = new StringBuilder();
      for(int i = 0; i < len; i++){
        if((s & (1 << i)) == 0){
          sb.append(number[i]);
        }
      }
      if(sb.length() >= 2 && sb.charAt(0) == '0'){
        continue;
      }
      int sum = Integer.valueOf(sb.toString());
      if(sum % div == 0){
        min = Math.min(min, Integer.bitCount(s));
      }
    }

    System.out.println(min);
  }
}
