import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      String[][] cards = new String[52][52];
      int[] sp = new int [52];

      for(int i = 0; i < 52; i++){
        String s = scan.next();
        if(s.equals("#")){
          return;
        }
        cards[i][sp[i]++] = s;
      }

      int count = 52, j = 0;
      while(j < count){
        String s = cards[j][sp[j] - 1];
        if(j - 3 >= 0 &&
            (s.charAt(0) == cards[j - 3][sp[j - 3] - 1].charAt(0) ||
             s.charAt(1) == cards[j - 3][sp[j - 3] - 1].charAt(1))){
          cards[j - 3][sp[j - 3]++] = s;
          --sp[j];
          if(sp[j] == 0){
            for(int k = j; k < count - 1; k++){
              cards[k] = cards[k + 1];
              sp[k] = sp[k + 1];
            }
            --count; --j;
          }
          j = 0;
        }
        else if(j - 1 >= 0 &&
            (s.charAt(0) == cards[j - 1][sp[j - 1] - 1].charAt(0) ||
             s.charAt(1) == cards[j - 1][sp[j - 1] - 1].charAt(1))){
          cards[j - 1][sp[j - 1]++] = s;
          --sp[j];
          if(sp[j] == 0){
            for(int k = j; k < count - 1; k++){
              cards[k] = cards[k + 1];
              sp[k] = sp[k + 1];
            }
            --count; --j;
          }
          j = 0;
        }
        else{
          ++j;
        }
      }

      System.out.print(count + " piles remaining:");
      for(int i = 0; i < count; i++){
        System.out.print(" " + sp[i]);
      }
      System.out.println();
    }
  }
}
