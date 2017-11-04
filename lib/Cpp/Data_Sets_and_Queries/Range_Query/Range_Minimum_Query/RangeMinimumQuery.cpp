#include <iostream>
#include <vector>
#include <climits>
#include <string>
using namespace std;

class RangeMinimumQuery{
  public:
    const int MAX = INT_MAX;
    int n, size;
    vector< int > tree;

    RangeMinimumQuery(int n){
      this->n = n;
      size = 1;
      while(size < n){
        size <<= 1;
      }
      tree.resize((size << 1) - 1);
      fill(tree.begin(), tree.end(), MAX);
    }

    // change a_i to x
    void update(int i, int x){
      i += size - 1;
      tree[i] = x;
      while(i > 0){
        i = (i - 1) / 2;
        tree[i] = min(tree[2 * i + 1], tree[2 * i + 2]);
      }
    }

    // return the minimum element in [a, b)
    int find(int a, int b){
      return find(a, b, 0, 0, size);
    }

    int find(int a, int b, int i, int l, int h){
      if(h <= a || b <= l){
        return MAX;
      }
      if(a <= l && h <= b){
        return tree[i];
      }
      int vl = find(a, b, 2 * i + 1, l, (l + h) / 2);
      int vr = find(a, b, 2 * i + 2, (l + h) / 2, h);
      return min(vl, vr);
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

  RangeMinimumQuery rmq(n);
  string out;
  for(int i = 0; i < q; i++){
    if(com[i] == 0){
      rmq.update(x[i], y[i]);
    }
    else{
      out += to_string(rmq.find(x[i], y[i] + 1));
      out += "\n";
    }
  }

  cout << out;

  return 0;
}
