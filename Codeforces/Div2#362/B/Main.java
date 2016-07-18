import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    String[] aeb = s.split("e");

    double tmp = Double.parseDouble(aeb[0]);
    if(tmp == 0.0){
      System.out.println(0);
      return;
    }

    int b = Integer.parseInt(aeb[1]);

    int d;
    d = aeb[0].length() - 1;
    while(d >= 0 && aeb[0].charAt(d) == '0'){
      --d;
    }

    aeb[0] = aeb[0].substring(0, d + 1);

    d = 0;
    while(d < aeb[0].length() && aeb[0].charAt(d) != '.'){
      ++d;
    }

    StringBuilder ans = new StringBuilder();

    boolean flag = false;
    if(d + b + 1 >= aeb[0].length()){
      for(int i = 0; i <= d + b; i++){
        if(i == d){
          continue;
        }
        if(i < aeb[0].length()){
          if(flag || aeb[0].charAt(i) != '0'){
            ans.append(aeb[0].charAt(i));
            flag = true;
          }
        }
        else{
          ans.append("0");
        }
      }
    }
    else{
      flag = false;
      if(d + b == 1){
        flag = true;
      }
      for(int i = 0; i <= d + b; i++){
        if(i == d){
          continue;
        }
        if(i < aeb[0].length()){
          if(flag || aeb[0].charAt(i) != '0'){
            ans.append(aeb[0].charAt(i));
            flag = true;
          }
        }
        else{
          ans.append("0");
        }
      }
    }

    if(d + b + 1 < aeb[0].length()){
      ans.append(".");
      for(int i = d + b + 1; i < aeb[0].length(); i++){
        ans.append(aeb[0].charAt(i));
      }
    }

    if(d + b + 1 < aeb[0].length()){
      d = ans.length() - 1;
      while(d >= 0 && ans.charAt(d) == '0'){
        --d;
      }
    }
    else{
      d = ans.length() - 1;
    }

    System.out.println(ans.substring(0, d + 1));
  }
}
