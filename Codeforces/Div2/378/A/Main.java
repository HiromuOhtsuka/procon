import java.util.Scanner;

public class Main {
  static String s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    s = sc.next();
    char[] str = s.toCharArray();
    int j = -1, max = 1;
    for(int i = 0; i < str.length; i++){
      if(isVowel(str[i])){
        max = Math.max(max, i - j);
        j = i;
      }
    }
    max = Math.max(max, str.length - j);

    System.out.println(max);
  }

  private static boolean isVowel(char ch){
    switch(ch){
      case 'A': case 'E': case 'I': case 'O': case 'U': case 'Y':
        return true;
    }
    return false;
  }
}
