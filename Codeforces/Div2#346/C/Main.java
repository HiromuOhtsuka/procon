import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(), M = scan.nextInt();
    int[] A = new int[N];
    for(int i = 0; i < N; i++){
      A[i] = scan.nextInt();
    }
    List< Integer > ans = new ArrayList< Integer >();
    Arrays.sort(A);
    int s = 1;
    while(M > 0 && s <= M){
      if(Arrays.binarySearch(A, s) < 0){
        ans.add(s);
        M -= s;
      }
      ++s;
    }

    System.out.println(ans.size());
    for(int i = 0; i < ans.size(); i++){
      System.out.print(ans.get(i) + ((i == ans.size() - 1) ? "\n" : " "));
    }
  }

}
