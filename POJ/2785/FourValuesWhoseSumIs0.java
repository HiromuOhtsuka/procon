import java.util.Scanner;
import java.util.Arrays;

public class Main {
  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt();
    long[] A = new long[N], B = new long[N], C = new long[N], D = new long[N];
    for(int i = 0; i < N; i++){
      long a = scan.nextLong(), b = scan.nextLong(), 
           c = scan.nextLong(), d = scan.nextLong();
      A[i] = a; B[i] = b; C[i] = c; D[i] = d;
    }

    long[] CD = new long[N*N];
    int sp = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        CD[sp++] = C[i] + D[j];
      }
    }
    Arrays.sort(CD);

    long count = 0;
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        long tar = -(A[i] + B[j]);
        int s = Arrays.binarySearch(CD, tar);
        if(s >= 0){
          int l = s, r = s;
          while(l >= 0 && CD[l] == tar){
            --l;
          }
          while(r < CD.length && CD[r] == tar){
            ++r;
          }
          count += (r - l) - 1;
        }
      }
    }

    System.out.println(count);
  }
}
