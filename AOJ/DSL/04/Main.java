import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class Main{
  static int n;
  static int[] x1, y1, x2, y2;
  static final boolean DEBUG = false;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    x1 = new int[n];
    y1 = new int[n];
    x2 = new int[n];
    y2 = new int[n];
    for(int i = 0; i < n; i++){
      x1[i] = sc.nextInt();
      y1[i] = sc.nextInt();
      x2[i] = sc.nextInt();
      y2[i] = sc.nextInt();
    }

    List< Integer > cx = compress(x1, x2);
    List< Integer > cy = compress(y1, y2);

    int[][] event = new int[cy.size()][cx.size()];
    for(int i = 0; i < n; i++){
      event[y1[i]][x1[i]]++;
      //event[y2[i] + 1][x1[i]]--;
      event[y2[i]][x1[i]]--;
      //event[y1[i]][x2[i] + 1]--;
      event[y1[i]][x2[i]]--;
      //event[y2[i] + 1][x2[i] + 1]++;
      event[y2[i]][x2[i]]++;
      if(DEBUG){
        for(int j = 0; j < event.length; j++){
          for(int k = 0; k < event[j].length; k++){
            System.out.print(event[j][k] + " ");
          }
          System.out.println();
        }
        System.out.println("---");
      }
    }

    int state = 0;
    for(int i = 0; i < cx.size(); i++){
      for(int j = 0; j < cy.size(); j++){
        state += event[j][i];
        event[j][i] = state;
      }
    }
    state = 0;
    for(int i = 0; i < cy.size(); i++){
      for(int j = 0; j < cx.size(); j++){
        state += event[i][j];
        event[i][j] = state;
      }
    }

    if(DEBUG){
      for(int j = 0; j < event.length; j++){
        for(int k = 0; k < event[j].length; k++){
          System.out.print(event[j][k] + " ");
        }
        System.out.println();
      }
      System.out.println("---");
    }

    long sum = 0;
    for(int i = 0; i < cy.size(); i++){
      for(int j = 0; j < cx.size(); j++){
        if(event[i][j] > 0 && j + 1 < cx.size() && i + 1 < cy.size()){
          sum += (long)(cx.get(j + 1) - cx.get(j)) * (long)(cy.get(i + 1) - cy.get(i));
        }
      }
    }

    System.out.println(sum);
  }

  static List< Integer > compress(int[] x1, int[] x2){
    Set< Integer > set = new HashSet< >();
    for(int i = 0; i < n; i++){
      set.add(x1[i]);
      set.add(x2[i]);
    }
    List< Integer > list = new ArrayList< >(set);
    Collections.sort(list);
    for(int i = 0; i < n; i++){
      x1[i] = Collections.binarySearch(list, x1[i]);
      x2[i] = Collections.binarySearch(list, x2[i]);
    }
    return list;
  }
}
