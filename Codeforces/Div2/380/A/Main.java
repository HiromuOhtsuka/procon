import java.util.Scanner;

public class Main {
  static int n;
  static char[] str;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    str = sc.next().toCharArray();

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < str.length; ){
      if(i + 2 < str.length && 
        str[i] == 'o' && str[i + 1] == 'g' && str[i + 2] == 'o'){
        sb.append("***"); i += 3;
        while(i + 1 < str.length && str[i] == 'g' && str[i + 1] == 'o'){
          i += 2;
        }
      }
      else{
        sb.append(str[i]);
        ++i;
      }
    }

    System.out.println(sb);
  }
}
