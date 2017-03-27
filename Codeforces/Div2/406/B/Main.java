import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class Main{
  static int n, m;
  static int[][] v;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    m = sc.nextInt();
    v = new int[m][];
    for(int i = 0; i < m; i++){
      int k = sc.nextInt();
      v[i] = new int[k];
      for(int j = 0; j < k; j++){
        v[i][j] = sc.nextInt();
      }
    }

    List< Set< Integer > > vSets = new ArrayList< >();
    for(int i = 0; i < m; i++){
      vSets.add(new HashSet< >());
    }
    boolean[] safe = new boolean[m];
    for(int i = 0; i < m; i++){
      if(v[i].length == 1){
        System.out.println("YES");
        return;
      }
      for(int j = 0; j < v[i].length; j++){
        if(vSets.get(i).contains(-v[i][j])){
          safe[i] = true;
        }
        vSets.get(i).add(v[i][j]);
      }
    }

    for(int i = 0; i < m; i++){
      if(!safe[i]){
        System.out.println("YES");
        return;
      }
    }
    System.out.println("NO");
  }
}
