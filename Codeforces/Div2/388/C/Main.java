import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;

public class Main{
  static int n;
  static char[] s;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    s = sc.next().toCharArray();

    TreeSet< Integer > d = new TreeSet< >();
    TreeSet< Integer > r = new TreeSet< >();
    for(int i = 0; i < n; i++){
      if(s[i] == 'D'){
        d.add(i);
      }
      else{
        r.add(i);
      }
    }

    boolean[] right = new boolean[n];
    Arrays.fill(right, true);

    int rest = n;
    while(rest != 1){
      for(int i = 0; i < n; i++){
        if(rest == 1){
          break;
        }
        if(right[i] && s[i] == 'D'){
          if(!r.isEmpty()){
            Integer j = r.higher(i);
            if(j == null){
              j = r.first();
            }
            right[j] = false;
            r.remove(j);
          }
          else{
            Integer j = d.higher(i);
            if(j == null){
              j = d.first();
            }
            right[j] = false;
            d.remove(j);
          }
          --rest;
        }
        else if(right[i] && s[i] == 'R'){
          if(!d.isEmpty()){
            Integer j = d.higher(i);
            if(j == null){
              j = d.first();
            }
            right[j] = false;
            d.remove(j);
          }
          else{
            Integer j = r.higher(i);
            if(j == null){
              j = r.first();
            }
            right[j] = false;
            r.remove(j);
          }
          --rest;
        }
      }
    }

    for(int i = 0; i < n; i++){
      if(right[i]){
        System.out.println(s[i]);
        return;
      }
    }
  }
}
