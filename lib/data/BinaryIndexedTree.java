class BinaryIndexedTree {
  int n;
  long[] bit;

  BinaryIndexedTree(int n){
    this.n = n;
    this.bit = new long[n + 1];
  }

  long sum(int i){
    long s = 0;
    while(i > 0){
      s += bit[i];
      i -= i & -i;
    }
    return s;
  }

  void add(int i, long x){
    while(i <= n){
      bit[i] += x;
      i += i & -i;
    }
  }
}
