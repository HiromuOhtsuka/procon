import java.util.Scanner;

public class Main {
  static int n, q;
  static int[] t, k, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); q = sc.nextInt();
    t = new int[q]; k = new int[q]; d = new int[q];
    for(int i = 0; i < q; i++){
      t[i] = sc.nextInt();
      k[i] = sc.nextInt();
      d[i] = sc.nextInt();
    }

    int[] ans = new int[q];
    int[] finishTime = new int[n], lowsI = new int[n];
    for(int i = 0; i < q; i++){
      int sp = 0;
      for(int j = 0; j < n; j++){
        if(sp < k[i] && finishTime[j] <= t[i]){
          lowsI[sp++] = j;
        }
      }
      if(sp == k[i]){
        for(int j = 0; j < sp; j++){
          ans[i] += (lowsI[j] + 1);
          finishTime[lowsI[j]] = t[i] + d[i];
        }
      }
      else{
        ans[i] = -1;
      }
    }

    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < q; i++){
      sb.append(ans[i] + System.lineSeparator());
    }

    System.out.print(sb);
  }
}
