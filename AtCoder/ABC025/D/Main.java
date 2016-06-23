import java.util.Scanner;

public class Main {
  static int[][] table;
  static int count;
  static long sum;
  static int[][] empty;
  static int[] perm;
  static int[] notUsed;
  static boolean[] used2;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    table = new int[5][5];
    empty = new int[25][2];
    boolean[] used = new boolean[25 + 1];
    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 5; j++){
        table[i][j] = sc.nextInt();
        used[table[i][j]] = true;
        if(table[i][j] == 0){
          empty[count][0] = i;  empty[count][1] = j;
          ++count;
        }
      }
    }

    notUsed = new int[count];
    int sp = 0;
    for(int i = 1; i <= 25; i++){
      if(!used[i]){
        notUsed[sp++] = i;
      }
    }

    perm = new int[count];
    used2 = new boolean[count];
    permutation(0);

    System.out.println(sum);
  }

  private static void permutation(int i){
    if(i == count){
      // debug
      /*
      System.out.println("perm:");
      for(int j = 0; j < count; j++){
        System.out.print(" " + perm[j]);
      }
      System.out.println();
      */
      for(int j = 0; j < count; j++){
        int x = empty[j][1], y = empty[j][0];
        table[y][x] = notUsed[perm[j]];
      }
      /*
      System.out.println("---");
      for(int j = 0; j < 5; j++){
        for(int k = 0; k < 5; k++){
          System.out.print(" " + table[j][k]);
        }
        System.out.println();
      }
      System.out.println("---");
      */
      if(check()){
        sum = (sum + 1) % 1000000007;
      }
      return;
    }

    for(int j = 0; j < count; j++){
      if(!used2[j]){
        perm[i] = j;
        used2[j] = true;
        permutation(i + 1);
        used2[j] = false;
      }
    }
  }

  private static boolean check(){
    for(int i = 0; i < 3; i++){
      for(int j = 0; j < 5; j++){
        if(table[i][j] == 0 ||
            table[i + 1][j] == 0 ||
            table[i + 2][j] == 0){
          continue;
        }
        if((table[i][j] < table[i + 1][j] &&
              table[i + 1][j] < table[i + 2][j]) ||
            (table[i][j] > table[i + 1][j] &&
             table[i + 1][j] > table[i + 2][j])){
          return false;
        }
      }
    }

    for(int i = 0; i < 5; i++){
      for(int j = 0; j < 3; j++){
        if(table[i][j] == 0 ||
            table[i][j + 1] == 0 ||
            table[i][j + 2] == 0){
          continue;
        }
        if((table[i][j] < table[i][j + 1] &&
              table[i][j + 1] < table[i][j + 2]) ||
            (table[i][j] > table[i][j + 1] &&
             table[i][j + 1] > table[i][j + 2])){
          return false;
        }
      }
    }

    return true;
  }
}
