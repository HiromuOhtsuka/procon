#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 200000
using namespace std;

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

vector< int > graph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m, s;
  cin >> n >> m >> s;
  for(int i = 0; i < m; i++){
    int u, v;
    cin >> u >> v;
    graph[u - 1].push_back(v - 1);
    graph[v - 1].push_back(u - 1);
  }
  --s;

  vector< int > order;
  UnionFindTree uf(n);
  for(int v = n - 1; v >= 0; v--){
    for(int w: graph[v]){
      if(w >= v){
        uf.unite(v, w);
      }
    }
    if(uf.same(s, v)){
      order.push_back(v);
    }
  }
  reverse(order.begin(), order.end());

  string ans;
  for(int v: order){
    ans += to_string(v + 1) + "\n";
  }

  cout << ans;

  return 0;
}
