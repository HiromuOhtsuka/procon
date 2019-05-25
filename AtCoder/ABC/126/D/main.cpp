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
using namespace std;

class edge {
  public:
    int u, v;
    int w;
    edge(int u, int v, int w): u(u), v(v), w(w){}
};

int n;
vector< edge > graph[MAX_N];

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

void dfs(int v, int p, ll d, int color[]){
  if(d % 2 == 0) color[v] = 0;
  else color[v] = 1;
  for(edge e: graph[v]){
    if(e.v != p) dfs(e.v, v, d + e.w, color);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n;
  int u[n - 1], v[n - 1], w[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> u[i] >> v[i] >> w[i];
    --u[i]; --v[i];
  }

  for(int i = 0; i < n - 1; i++){
    graph[u[i]].push_back(edge(u[i], v[i], w[i]));
    graph[v[i]].push_back(edge(v[i], u[i], w[i]));
  }

  int color[n];
  fill(color, color + n, -1);
  dfs(0, -1, 0, color);

  string buf;
  for(int v = 0; v < n; v++){
    buf += to_string(color[v]) + "\n";
  }

  cout << buf;

  return 0;
}
