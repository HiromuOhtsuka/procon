#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
#define MAX_LOG 20
using namespace std;

class edge{
  public:
    int u, v, c;
    edge(){}
    edge(int u, int v, int c): u(u), v(v), c(c){}
};

vector< vector< edge > > tree;

void dfs(int v, int p, long long d, long long dist[]){
  dist[v] = d;
  for(edge e: tree[v]){
    int w = e.v;
    if(w != p){
      dfs(w, v, d + e.c, dist);
    }
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n - 1], b[n - 1], c[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> a[i] >> b[i] >> c[i];
  }
  int q, k;
  cin >> q >> k;
  int x[q], y[q];
  for(int i = 0; i < q; i++){
    cin >> x[i] >> y[i];
  }
  tree.resize(n);
  for(int i = 0; i < n - 1; i++){
    int s = a[i] - 1, t = b[i] - 1;
    tree[s].emplace_back(edge(s, t, c[i]));
    tree[t].emplace_back(edge(t, s, c[i]));
  }

  long long dist[n];
  dfs(k - 1, -1, 0, dist);

  string ans;
  for(int i = 0; i < q; i++){
    long long d = dist[x[i] - 1] + dist[y[i] - 1];
    ans += to_string(d) + "\n";
  }

  cout << ans;

  return 0;
}
