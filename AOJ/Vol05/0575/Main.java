import java.util.Scanner;

public class Main {
  static int N, M, K, Q;

  static class Vertex {
    static final int INIT_SIZE = 128;
    int degree, size;
    int[] neighbor;

    Vertex(){
      neghbor = new int[INIT_SIZE];
    }

    void add(int v){
      neighbor[size++] = v;
    }

    int size(){
      return size;
    }

  }

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
  }
}
