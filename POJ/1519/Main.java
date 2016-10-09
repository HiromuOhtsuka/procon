import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    StringBuilder sb = new StringBuilder();
    while(sc.hasNext()){
      String s = sc.next();
      if("0".equals(s)){
        break;
      }

      char[] str = s.toCharArray();
      int sum = 0;
      for(;;){
        for(int i = 0; i < str.length; i++){
          sum += str[i] - '0';
        }

        if(sum >= 10){
          str = Integer.toString(sum).toCharArray();
          sum = 0;
        }
        else{
          break;
        }
      }

      sb.append(sum + "\n");
    }

    System.out.print(sb);
  }
}
