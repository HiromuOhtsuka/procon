import java.util.Scanner;

public class Main {
  static int n, k;
  static int a, b, c, d;

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    n = sc.nextInt(); k = sc.nextInt();
    a = sc.nextInt() - 1; b = sc.nextInt() - 1;
    c = sc.nextInt() - 1; d = sc.nextInt() - 1;

    if(n + 1 > k || n == 4){
      System.out.println(-1);
      return;
    }

    int[] mem = new int[n - 4];
    int sp = 0;
    for(int i = 0; i < n; i++){
      if(i != a && i != b && i != c && i != d){
        mem[sp++] = i;
      }
    }

    int[] ans1 = new int[n];
    ans1[0] = a;  ans1[1] = c;
    ans1[n - 2] = d;  ans1[n - 1] = b;
    for(int i = 2; i < n - 2; i++){
      ans1[i] = mem[sp - i + 1];
    }
    int[] ans2 = new int[n];
    ans2[0] = c;  ans2[1] = a;
    ans2[n - 2] = b;  ans2[n - 1] = d;
    for(int i = 2; i < n - 2; i++){
      ans2[i] = mem[sp - i + 1];
    }

    for(int i = 0; i < n; i++){
      System.out.print((ans1[i] + 1) + ((i == n - 1) ? "\n" : " "));
    }
    for(int i = 0; i < n; i++){
      System.out.print((ans2[i] + 1) + ((i == n - 1) ? "\n" : " "));
    }
  }
}
