import java.util.Scanner;

public class Main {
   static int n, q;

   public static void main(String[] args){
     Scanner sc = new Scanner(System.in);

     n = sc.nextInt();  q = sc.nextInt();
     int[] a = new int[n], b = new int[n];
     for(int i = 0; i < q; i++){
       int l = sc.nextInt() - 1, r = sc.nextInt() - 1;
        ++a[l];  --b[r];
     }

     int[] ans = new int[n];
     int c = 0;
     for(int i = 0; i < n; i++){
       c += a[i];
       if(c > 0 && c % 2 == 1){
         ans[i] = 1;
       }
       c += b[i];
     }

     for(int i = 0; i < n; i++){
       System.out.print(ans[i]);
     }
     System.out.println();
   }
}
