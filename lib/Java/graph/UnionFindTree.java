class UnionFindTree {
  private int N;
  private int[] root, rank;

  public UnionFindTree(int n){
    this.N = n;
    this.root = new int[N];
    this.rank = new int[N];
    for(int i = 0; i < root.length; i++){
      root[i] = i;
    }
  }

  public void union(int v, int w){
    int vr = root(v), wr = root(w);
    if(vr == wr){
      return;
    }
    if(rank[vr] < rank[wr]){
      root[vr] = wr;
    }
    else{
      root[wr] = vr;
      if(rank[vr] == rank[wr]){
        ++rank[vr];
      }
    }
  }

  public int root(int v){
    if(root[v] == v){
      return v;
    }
    return root[v] = root(root[v]);
  }

  public boolean isSame(int v, int w){
    return root(v) == root(w);
  }
}
