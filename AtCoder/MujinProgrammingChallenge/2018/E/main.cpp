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
using namespace std;

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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m, k;
  cin >> n >> m >> k;
  string d;
  cin >> d;
  string s[MAX_N];
  for(int i = 0; i < n; i++) cin >> s[i];

  char dir[] = {'R', 'U', 'L', 'D'};

  ll nd[k][4];
  for(int i = 0; i < k; i++){
    fill(nd[i], nd[i] + 4, INF_LONG);
  }

  ll nd0[4];
  fill(nd0, nd0 + 4, INF_LONG);
  for(int i = k - 1; i >= 0; i--){
    switch(d[i]){
      case 'R': nd0[0] = i; break;
      case 'U': nd0[1] = i; break;
      case 'L': nd0[2] = i; break;
      case 'D': nd0[3] = i; break;
    }
  }

  for(int i = k - 1; i >= 0; i--){
    for(int j = 0; j < 4; j++){
      if(nd0[j] != INF_LONG){
        if(i - nd0[j] >= 0)
          nd[i][j] = k - (i - nd0[j]);
        else nd[i][j] = nd0[j] - i;
      }
    }
    switch(d[i]){
      case 'R': nd0[0] = i; break;
      case 'U': nd0[1] = i; break;
      case 'L': nd0[2] = i; break;
      case 'D': nd0[3] = i; break;
    }
  }

  pii sp, gp;
  for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
      if(s[i][j] == 'S') sp = make_pair(i, j);
      if(s[i][j] == 'G') gp = make_pair(i, j);
    }
  }

  ll dist[n][m];
  for(int i = 0; i < n; i++){
    fill(dist[i], dist[i] + m, INF_LONG);
  }

  int dx[] = {1, 0, -1, 0};
  int dy[] = {0, -1, 0, 1};
  priority_queue< pair< ll, pii >, 
    vector< pair< ll, pii > >, greater< pair< ll, pii > > > que;
  que.push(make_pair(0, sp));
  while(!que.empty()){
    pair< ll, pii > p = que.top();
    que.pop();
    ll t = p.first;
    pii at = p.second;
    if(dist[at.first][at.second] < t) continue;
    dist[at.first][at.second] = t;
    for(int i = 0; i < 4; i++){
      int ni = at.first + dy[i];
      int nj = at.second + dx[i];
      if(!(ni >= 0 && ni < n) || 
          !(nj >= 0 && nj < m)) continue;
      if(s[ni][nj] == '#') continue;
      ll cost = nd[(t - 1 + k)  % k][i];
      if(cost == INF_LONG) continue;
      if(t + cost < dist[ni][nj]){
        dist[ni][nj] = t + cost;
        que.push(make_pair(t + cost, make_pair(ni, nj)));
      }
    }
  }

  if(dist[gp.first][gp.second] == INF_LONG) cout << -1 << endl;
  else cout << dist[gp.first][gp.second] << endl;

  return 0;
}
