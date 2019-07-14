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

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

vector< int > graph[3 * MAX_N];

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

  int n, m;
  cin >> n >> m;
  int u[m], v[m];
  for(int i = 0; i < m; i++){
    cin >> u[i] >> v[i];
    --u[i]; --v[i];
  }
  int s, t;
  cin >> s >> t;
  --s; --t;

  for(int i = 0; i < m; i++){
    int u0 = 3 * u[i], u1 = u0 + 1, u2 = u0 + 2;
    int v0 = 3 * v[i], v1 = v0 + 1, v2 = v0 + 2;
    graph[u0].push_back(v1);
    graph[u1].push_back(v2);
    graph[u2].push_back(v0);
  }

  int dist[3 * n];
  queue< int > que;
  fill(dist, dist + 3 * n, INF_INT);
  dist[3 * s] = 0;
  que.push(3 * s);
  while(!que.empty()){
    int vv = que.front(); que.pop();
    for(int w: graph[vv]){
      if(dist[w] == INF_INT){
        dist[w] = dist[vv] + 1;
        que.push(w);
      }
    }
  }

  if(dist[3 * t] != INF_INT) cout << (dist[3 * t] / 3) << endl;
  else cout << -1 << endl;

  return 0;
}
