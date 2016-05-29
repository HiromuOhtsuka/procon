class RangeMaximumQuery {
  static final int MIN = 0;
  int n;
  int[] tree;

  RangeMaximumQuery(int n){
    this.n = 1;
    while(this.n < n){
      this.n <<= 1;
    }
    this.tree = new int[this.n << 2];
    for(int i = 0; i < tree.length; i++){
      tree[i] = MIN;
    }
  }

  void update(int i, int x){
    i += n - 1;
    tree[i] = x;
    while(i > 0){
      i = (i - 1) / 2;
      tree[i] = Math.max(tree[2 * i + 1], tree[2 * i + 2]);
    }
  }

  int get(int a, int b){
    return get(a, b, 0, 0, n);
  }

  int get(int a, int b, int i, int l, int h){
    if(h <= a || b <= l){
      return MIN;
    }
    if(a <= l && h <= b){
      return tree[i];
    }
    int vl = get(a, b, 2 * i + 1, l, (l + h) / 2);
    int vr = get(a, b, 2 * i + 2, (l + h) / 2, h);
    return Math.max(vl, vr);
  }
}
