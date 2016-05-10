import java.util.Scanner;

public class Main {
  int N, Q;
  long[] A, bit0, bit1;

  Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt(); Q = scan.nextInt();
    A = new long[N];
    for(int i = 0; i < N; i++){
      A[i] = scan.nextLong();
    }

    bit0 = new long[N + 1];
    bit1 = new long[N + 1];
    for(int i = 0; i < N; i++){
      add(bit0, i + 1, A[i]);
    }

    scan.nextLine();
    for(int i = 0; i < Q; i++){
      String[] as = scan.nextLine().split(" ");
      int a = Integer.parseInt(as[1]),
          b = Integer.parseInt(as[2]);
      if(as[0].equals("C")){
        long c = Long.parseLong(as[3]);
        add(bit0, a, -c * (a - 1));
        add(bit1, a, c);
        add(bit0, b + 1, c * b);
        add(bit1, b + 1, -c);
      }
      else{
        long sb = sum(bit1, b) * b + sum(bit0, b),
             sa = sum(bit1, a - 1) * (a - 1) + sum(bit0, a - 1);
        System.out.println(sb - sa);
      }
    }


  }

  long sum(long[] bit, int i){
    long s = 0;
    while(i > 0){
      s += bit[i];
      i -= i & -i;
    }
    return s;
  }

  void add(long[] bit, int i, long x){
    while(i <= N){
      bit[i] += x;
      i += i & -i;
    }
  }

  public static void main(String[] args){
    new Main();
  }
}
