import java.util.Scanner;
import java.math.BigInteger;

public final class Main {
  public Main(){
    Scanner scan = new Scanner(System.in);

    while(scan.hasNext()){
      String line = scan.nextLine();
      String[] exp = line.split("[+=]");
      boolean na = true;
      for(int i = 0; i < 10; i++){
        String e1 = exp[0].replace('X', (char)('0' + i)),
               e2 = exp[1].replace('X', (char)('0' + i)),
               e3 = exp[2].replace('X', (char)('0' + i));
        if(e1.matches("00+[0-9]*") || e2.matches("00+[0-9]*") ||
            e3.matches("00+[0-9]*")){
          continue;
        }
        BigInteger s1 = new BigInteger(e1),
                   s2 = new BigInteger(e2);
        String ans = s1.add(s2).toString();
        if(ans.equals(e3)){
          System.out.println(i);
          na = false;
          break;
        }
      }
      if(na){
        System.out.println("NA");
      }
    }
  }
  /*

     private String add(String s1, String s2){
     char[] str1 = s1.toCharArray(),
     str2 = s2.toCharArray();
     char[] ans = new char[
     (str1.length < str2.length ? str2.length : str1.length) + 1];
     for(int i = 0; i < ans.length; i++){
     ans[i] = '0';
     }

     char carry = '0';
     for(int i = 1; i <= ans.length; i++){
     char c1 = str1.length - i >= 0 ? str1[str1.length - i] : '0',
     c2 = str2.length - i >= 0 ? str2[str2.length - i] : '0';
     int i1 = c1 - '0', i2 = c2 - '0', ic = carry - '0';
     if(i1 + i2 + ic > 9){
     ans[ans.length - i] = (char)(i1 + i2 + ic - ('9' + 1) + '0');
     }
     else{
     ans[ans.length - i] = (char)(c1 + c2 + carry);
     }
     carry = (c1 + c2  + carry > '9') ? '1' : '0';
     }

     return new String(ans);
     }
   */

  public static void main(String[] args){
    new Main();
  }
}
