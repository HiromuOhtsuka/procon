import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int AN = scan.nextInt(), BN = scan.nextInt();
    int[] A = new int[AN], B = new int[BN];
    for(int i = 0; i < A.length; i++){
      A[i] = scan.nextInt();
    }
    for(int i = 0; i < B.length; i++){
      B[i] = scan.nextInt();
    }
    int best = 0;
    for(int b = 0; b < BN; b++){
      int at = -1;
      for(int j = b; j < BN; j++){
        boolean find = false;
        for(int k = at + 1; k < AN; k++){
          if(k > at && A[k] == B[j]){
            at = k;
            find = true;
            break;
          }
        }
        if(!find){
          best = Math.max(best, j - b);
          break;
        }
        if(find && j == BN - 1){
          best = Math.max(best, j - b + 1);
        }
      }
    }

    System.out.println(best);
  }
}
