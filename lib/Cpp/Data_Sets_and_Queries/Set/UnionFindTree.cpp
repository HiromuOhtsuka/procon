#include <iostream>
#include <vector>
#include <string>
using namespace std;

class UnionFindTree{
  public:
    int size;
    vector< int > parent;
    vector< int > rank;

    UnionFindTree(int n):
      size(n), parent(n, -1), rank(n, 0){}

    int root(int x){
      return ((parent[x] < 0) ?
        x : parent[x] = root(parent[x]));
    }

    bool unite(int x, int y){
      int rx = root(x), ry = root(y);
      if(rx == ry){
        return false;
      }
      if(rank[rx] < rank[ry]){
        parent[rx] = ry;
      }
      else{
        parent[ry] = rx;
      }
      if(rank[rx] == rank[ry]){
        ++rank[rx];
      }
      --size;
      return true;
    }

    bool same(int x, int y){
      return root(x) == root(y);
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

  string out;
  UnionFindTree uf(n);
  for(int i = 0; i < q; i++){
    if(com[i] == 0){
      uf.unite(x[i], y[i]);
    }
    else{
      bool ans = uf.same(x[i], y[i]);
      out += to_string(ans ? 1 : 0);
      out += "\n";
    }
  }

  cout << out;

  return 0;
}
