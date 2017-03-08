import java.util.Scanner;

public class Main{
  static int n;
  static boolean[] seq;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt();
    seq = new boolean[n];
    for(int i = 0; i < n; i++){
      seq[i] = (sc.nextInt() == 1);
    }

    int s = 0;
    int max = 2;
    while(s < n){
      int t = s + 1;
      int count = 0;
      int next = t;
      boolean state = seq[s];
      boolean reversing = false;
      for(;;){
        if(t >= n){
          break;
        }
        if(!state == (reversing ^ seq[t])){
          state = (reversing ^ seq[t]);
          ++t;
        }
        else if(reversing){
          reversing = false;
        }
        else if(count < 1){
          reversing = true;
          next = t;
          ++count;
        }
        else{
          break;
        }
      }
      max = Math.max(max, (t - s));
      s = next;
    }

    System.out.println(max);
  }
}
