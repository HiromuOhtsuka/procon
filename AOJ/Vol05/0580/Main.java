import java.util.Scanner;
import java.util.Arrays;

public class Main {
  static final int MAX_N = 50;
  static final int MAX_K = 50;
  static final int MAX_VAL = 1000000;

  static class Point {
    int x, y, z;

    Point(int x, int y, int z){
      this.x = x;
      this.y = y;
      this.z = z;
    }
  }

  static class Section {
    Point f, s;

    Section(Point f, Point s){
      this.f = f;
      this.s = s;
    }
  }

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);

    int N = scan.nextInt(), K = scan.nextInt();
    int[] x = new int[MAX_N*2], y = new int[MAX_N*2], z = new int[MAX_N*2];
    int sp = 0;
    Section[] S = new Section[N];
    for(int i = 0; i < N; i++){
      int x1, x2, y1, y2, d1, d2;
      x1 = scan.nextInt(); y1 = scan.nextInt(); d1 = scan.nextInt();
      x2 = scan.nextInt(); y2 = scan.nextInt(); d2 = scan.nextInt();
      S[i] = new Section(new Point(x1, y1, d1), new Point(x2, y2, d2));
      x[sp] = x1; y[sp] = y1; z[sp] = d1; ++sp;
      x[sp] = x2; y[sp] = y2; z[sp] = d2; ++sp;
    }

    Arrays.sort(x, 0, sp); Arrays.sort(y, 0, sp); Arrays.sort(z, 0, sp);
    int[] reX = new int[MAX_VAL+1], reY = new int[MAX_VAL+1], reZ = new int[MAX_VAL+1];
    for(int i = 0; i < sp; i++){
      reX[x[i]] = i;  reY[y[i]] = i;  reZ[z[i]] = i;
    }
    int[][][] count = new int[MAX_N*2][MAX_N*2][MAX_N*2];
    for(int i = 0; i < N; i++){
      for(int xi = reX[S[i].f.x]; xi < reX[S[i].s.x]; xi++){
        for(int yi = reY[S[i].f.y]; yi < reY[S[i].s.y]; yi++){
          for(int zi = reZ[S[i].f.z]; zi < reZ[S[i].s.z]; zi++){
            ++count[xi][yi][zi];
          }
        }
      }
    }
    long V = 0;
    for(int i = 0; i < sp - 1; i++){
      for(int j = 0; j < sp - 1; j++){
        for(int k = 0; k < sp - 1; k++){
          if(count[i][j][k] >= K){
            V += (long)(((long)x[i + 1] - (long)x[i]) * ((long)y[j + 1] - (long)y[j]) * ((long)z[k + 1] - (long)z[k]));
          }
        }
      }
    }

    System.out.println(V);
  }
}
