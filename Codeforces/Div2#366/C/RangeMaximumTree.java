class RangeSum {
  int n;
  int[] tree;

  RangeMaximumQuery(int n){
    this.n = 1;
    while(this.n < n){
      this.n <<= 1;
    }
    this.tree = new int[this.n << 2];
  }

  void update(int i, int x){
    i += n - 1;
    tree[i] = x;
    while(i > 0){
      i = (i - 1) / 2;
      tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
  }

  int get(int a, int b){
    return get(a, b, 0, 0, n);
  }

  int get(int a, int b, int i, int l, int h){
    if(h <= a || b <= l){
      return 0;
    }
    if(a <= l && h <= b){
      return tree[i];
    }
    int vl = get(a, b, 2 * i + 1, l, (l + h) / 2);
    int vr = get(a, b, 2 * i + 2, (l + h) / 2, h);
    return vl + vr;
  }
}
