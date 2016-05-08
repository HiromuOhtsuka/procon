import java.util.Scanner;

public class Main {
  int N, C;

  double[] S, VX, VY, ANG;

  Main(){
    Scanner scan = new Scanner(System.in);
      ANG = new double[(1 << 15) - 1];
      VX = new double[(1 << 15) - 1];
      VY = new double[(1 << 15) - 1];

      int count = 0;
    while(scan.hasNext()){
      if(count != 0){
        System.out.println();
      }

      N = scan.nextInt(); C = scan.nextInt();
      S = new double[N];
      for(int i = 0; i < N; i++){
        S[i] = scan.nextDouble();
      }

      init(0, 0, N);
      double[] pra = new double[N];
      for(int i = 1; i < N; i++){
        pra[i] = Math.PI;
      }

      for(int i = 0; i < C; i++){
        int s = scan.nextInt();
        double ang = scan.nextDouble() / 360.0 * 2 * Math.PI;

        change(s, ang - pra[s], 0, 0, N);
        pra[s] = ang;

        System.out.printf("%.2f %.2f\n", VX[0], VY[0]);
      }

      ++count;
    }

  }

  void init(int k, int l, int r){
    VX[k] = ANG[k] = 0;

    if(r - l == 1){
      VY[k] = S[l];
      return;
    }
    int chl = 2 * k + 1, chr = 2 * k + 2;
    init(chl, l, (l + r) / 2);
    init(chr, (l + r) / 2, r);
    VY[k] = VY[chl] + VY[chr];
  }

  void change(int s, double a, int v, int l, int r){
    if(s <= l || s >= r){
      return;
    }
    int chl = 2 * v + 1, chr = 2 * v + 2;
    int m = (l + r) / 2;
    change(s, a, chl, l, m);
    change(s, a, chr, m, r);
    if(s <= m){
      ANG[v] += a;
    }
    double sin = Math.sin(ANG[v]), cos = Math.cos(ANG[v]);
    VX[v] = VX[chl] + (VX[chr] * cos - VY[chr] * sin);
    VY[v] = VY[chl] + (VX[chr] * sin + VY[chr] * cos);
  }

  public static void main(String[] args){
    new Main();
  }
}
