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
#define MAX_N 1000
#define MAX_M 1000
using namespace std;

int n, m;
int p[MAX_N];
int b[MAX_M];
int c[MAX_M];
vector< int > graph[MAX_N];

int e[MAX_N + 1];

typedef long long ll;
typedef pair< int, int > pii;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int dfs2(int v, int p, int d){
  if(graph[v].size() == 1){
    return e[v] - d;
  }
  int mi = INF_INT;
  for(int w: graph[v]){
    if(w != p){
      mi = min(mi, dfs2(w, v, d));
    }
  }
  return mi;
}

int dfs1(int v, int p, int d){
  int sum = 0;
  for(int w: graph[v]){
    if(w != p){
      int tmp = dfs2(w, v, d);
      sum += tmp;
      sum += dfs1(w, v, d + tmp);
    }
  }
  return sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < n - 1; i++) cin >> p[i];
  for(int i = 0; i < m; i++) cin >> b[i] >> c[i];

  for(int i = 0; i < n - 1; i++){
    graph[i + 1].push_back(p[i]);
    graph[p[i]].push_back(i + 1);
  }

  for(int i = 0; i < m; i++){
    e[b[i]] = c[i];
  }

  int ans = dfs1(0, -1, 0);

  cout << ans << endl;

  return 0;
}
