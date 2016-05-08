import java.util.Scanner;

public final class Main {
  private int N, D;
  private int[] x, y;
  private boolean[] isWorking;
  private UnionFind uf;

  private static class UnionFind {
    public static final int NO_PARENT = -1;
    private int[] parent;
    private int [] d;
    private int size;

    UnionFind(int size){
      this.size = size;
      this.parent = new int[size];
      this.d = new int[size];
      for(int i = 0; i < size; i++){
        this.parent[i] = i;
        this.d[i] = 0;
      }
    }

    int findParent(int v){
      if(v <= -1 || v >= size){
        return NO_PARENT;
      }
      if(parent[v] == v){
        return v;
      }
      parent[v] = findParent(parent[v]);
      return parent[v];
    }

    void union(int u, int v){
      int up = findParent(u), vp = findParent(v);
      if(up == vp){
        return;
      }
      if(d[up] < d[vp]){
        parent[up] = vp;
      }
      else{
        parent[vp] = up;
        if(d[up] == d[vp]){
          ++d[up];
        }
      }
    }

    boolean same(int u, int v){
      return findParent(u) == findParent(v);
    }

  }

  public Main(){
    Scanner scan = new Scanner(System.in);

    N = scan.nextInt();   D = scan.nextInt();
    x = new int[N];   y = new int[N];
    for(int i = 0; i < x.length; i++){
      x[i] = scan.nextInt();  y[i] = scan.nextInt();
    }
    uf = new UnionFind(N);
    isWorking = new boolean[N];
    while(scan.hasNextLine()){
      String ope = scan.nextLine();
      if(!"".equals(ope)){
        operate(ope);
      }

    }
  }

  private void operate(String ope){
    String[] opes = ope.split("\\s");
    if(ope.charAt(0) == 'O'){
      int p = Integer.parseInt(opes[1]) - 1;
      if(!isWorking[p]){
        isWorking[p] = true;
        for(int i = 0; i < N; i++){
          if(isWorking[i] && (x[p] - x[i])*(x[p] - x[i]) + (y[p] - y[i]) * (y[p] - y[i]) <= D*D){
            uf.union(p, i);
          }
        }
      }
    }
    else if(ope.charAt(0) == 'S'){
      int p = Integer.parseInt(opes[1]) - 1, q = Integer.parseInt(opes[2]) - 1;
      if(!((0 <= p && p < N) && (0 <= q && q < N))){
        System.out.println("FAIL");
        return;
      }
      if(isWorking[p] && isWorking[q] && uf.same(p, q)){
        System.out.println("SUCCESS");
      }
      else{
        System.out.println("FAIL");
      }
    }
  }

  public static void main(String[] args){
    new Main();
  }
}
