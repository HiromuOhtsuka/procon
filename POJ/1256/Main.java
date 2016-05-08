import java.util.Scanner;
import java.util.Comparator;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Main {
  static int N;
  static char[] perm; // 順列に対応する文字列
  static boolean[] used;  // その番号を使用したかどうか。順列生成のために使用。
  static char[] maxStr; // 今までの最大の文字列
  static Comparator< Character > cp;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    cp = new Comparator< Character >(){
      @Override
        public int compare(Character c1, Character c2){
          char ch1 = c1.charValue(), ch2 = c2.charValue();
          return compareChar(ch1, ch2);
        }
    };

    N = sc.nextInt();
    used = new boolean[12];
    sc.nextLine();
    for(int i = 0; i < N; i++){
      String s = sc.nextLine();
      // 入力文字列をCharacter[]に変換
      Character[] stro = new Character[s.length()];
      for(int j = 0; j < stro.length; j++){
        stro[j] = s.charAt(j);
      }
      // Character[]をソート
      Arrays.sort(stro, cp);
      // Character[]からchar[]へ変換
      char[] str = new char[stro.length];
      for(int j = 0; j < str.length; j++){
        str[j] = stro[j];
      }

      maxStr = new char[str.length];
      perm = new char[str.length];
      maxStr[0] = '\0';

      search(str, 0);
    }
  }

  private static void search(char[] str, int i){
    // 枝刈り
    if(compareChars(perm, maxStr, i) <= 0){
      return;
    }

    // 底
    if(i == str.length){
      System.out.println(perm);
      for(int j = 0; j < str.length; j++){
        maxStr[j] = perm[j];
      }
      return;
    }

    for(int j = 0; j < str.length; j++){
      if(!used[j]){
        perm[i] = str[j];
        used[j] = true;
        search(str, i + 1);
        used[j] = false;
      }
    }
  }

  private static int compareChar(char ch1, char ch2){
    char chl1 = Character.toLowerCase(ch1), chl2 = Character.toLowerCase(ch2);
    if(chl1 < chl2){
      return -1;
    }
    else if(chl1 > chl2){
      return 1;
    }
    else if(ch1 < ch2){
      return -1;
    }
    else if(ch1 > ch2){
      return 1;
    }
    else{
      return 0;
    }
  }

  private static int compareChars(char[] cc1, char[] cc2, int len){
    if(len <= 0){
      return 1;
    }
    for(int i = 0; i < len; i++){
      int tmp = compareChar(cc1[i], cc2[i]);
      if(tmp > 0){
        return 1;
      }
      else if(tmp < 0){
        return -1;
      }
    }
    return 0;
  }
}
