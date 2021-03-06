import java.util.Scanner;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    for(;;){
      int n, r;
      n = scan.nextInt(); r = scan.nextInt();
      if(n == 0 && r == 0) break;
      int[] a = new int[n+2];
      int sp = 0;
      for(sp=0; sp<=n; sp++){
        a[sp] = sp;
      }
      for(int i=0; i<r; i++){
        int p, c;
        p = scan.nextInt(); c = scan.nextInt();
        int d = c;
        while(d>0){
          int k = sp - (p-1) - c;
          int w = a[k];
          while(k < sp-1){
            a[k] = a[k+1];
            k++;
          }
          a[sp-1] = w;
          d--;
        }
      }
      System.out.println(a[sp-1]);
    }
  }
}
