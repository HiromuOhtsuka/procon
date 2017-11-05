#include <iostream>
#include <vector>
#include <string>
using namespace std;

class RangeSumQuery{
  public:
    int n, size;
    vector< int > tree;

    RangeSumQuery(int n){
      this->n = n;
      size = 1;
      while(size < n){
        size <<= 1;
      }
      tree.resize((size << 1) - 1);
      fill(tree.begin(), tree.end(), 0);
    }

    // add x to a_i
    void add(int i, int x){
      i += size - 1;
      tree[i] += x;
      while(i > 0){
        i = (i - 1) / 2;
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
      }
    }

    // return the sum of [a, b)
    int sum(int a, int b){
      return sum(a, b, 0, 0, size);
    }

    int sum(int a, int b, int i, int l, int h){
      if(h <= a || b <= l){
        return 0;
      }
      if(a <= l && h <= b){
        return tree[i];
      }
      int vl = sum(a, b, 2 * i + 1, l, (l + h) / 2);
      int vr = sum(a, b, 2 * i + 2, (l + h) / 2, h);
      return vl + vr;
    }
};

int n, q;
vector< int > com, x, y;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> q;
  com.resize(q);
  x.resize(q);
  y.resize(q);
  for(int i = 0; i < q; i++){
    cin >> com[i] >> x[i] >> y[i];
  }

  RangeSumQuery rmq(n);
  string out;
  for(int i = 0; i < q; i++){
    if(com[i] == 0){
      rmq.add(x[i] - 1, y[i]);
    }
    else{
      out += to_string(rmq.sum(x[i] - 1, y[i]));
      out += "\n";
    }
  }

  cout << out;

  return 0;
}
