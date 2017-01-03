import java.util.Scanner;

public class Main {
  static int n, k, a, b;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    a = sc.nextInt(); b = sc.nextInt();

    int ra = a, rb = b;
    char[] seq = new char[n];
    int sp = 0;
    boolean flag = false, possible = true;
    while(possible && sp < n){
      if(flag){
        if(seq[sp - 1] == 'B'){
          possible = (ra >= 1);
          seq[sp++] = 'G'; --ra;
        }
        else{
          possible = (rb >= 1);
          seq[sp++] = 'B';  --rb;
        }
        flag = false;
      }
      else{
        int diff = Math.abs(ra - rb);
        char ch = ((ra >= rb) ? 'G' : 'B');
        for(int j = 0; j < Math.max(1, Math.min(diff, k)); j++){
          seq[sp++] = ch;
          if(ch == 'G'){
            --ra;
          }
          else{
            --rb;
          }
        }
        if(diff >= k){
          flag = true;
        }
      }
    }

    if(!possible){
      System.out.println("NO");
    }
    else{
      System.out.println(seq);
    }
  }
}
