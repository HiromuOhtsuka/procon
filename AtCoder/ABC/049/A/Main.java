import java.util.Scanner;

public class Main {
  static char c;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    c = sc.next().charAt(0);

    boolean isVowel = false;
    switch(c){
      case 'a': case 'e': case 'i': case 'o': case 'u':
        isVowel = true;
    }

    if(isVowel){
      System.out.println("vowel");
    }
    else{
      System.out.println("consonant");
    }
  }
}
