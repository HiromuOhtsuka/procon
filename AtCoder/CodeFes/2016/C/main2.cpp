#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

int n, m;
int k[MAX_N];
vector< int > l[MAX_N];
vector< int > graph[MAX_N];

typedef long long ll;
typedef pair< int, int > pii;

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

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < n; i++){
    cin >> k[i];
    for(int j = 0; j < k[i]; j++){
      int tmp;
      cin >> tmp;
      l[i].push_back(tmp - 1);
    }
  }

  UnionFindTree uf(n + m);
  for(int i = 0; i < n; i++){
    for(int j = 0; j < k[i]; j++){
      uf.unite(i, n + l[i][j]);
    }
  }

  for(int i = 1; i < n; i++){
    if(!uf.same(0, i)){
      cout << "NO" << endl;
      return 0;
    }
  }

  cout << "YES" << endl;

  return 0;
}
