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
#define MAX_N 300
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

  int n, m, l;
  cin >> n >> m >> l;
  int a[m], b[m], c[m];
  for(int i = 0; i < m; i++) cin >> a[i] >> b[i] >> c[i];
  int q;
  cin >> q;
  int s[q], t[q];
  for(int i = 0; i < q; i++) cin >> s[i] >> t[i];

  int dist[n][n];
  for(int i = 0; i < n; i++){
    fill(dist[i], dist[i] + n, INF_INT);
    dist[i][i] = 0;
  }
  for(int i = 0; i < m; i++){
    dist[a[i] - 1][b[i] - 1] = c[i];
    dist[b[i] - 1][a[i] - 1] = c[i];
  }
  for(int k = 0; k < n; k++){
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        dist[i][j] = min(dist[i][k] + dist[k][j], dist[i][j]);
      }
    }
  }


  int dist2[n][n];
  for(int i = 0; i < n; i++){
    fill(dist2[i], dist2[i] + n, INF_INT);
    dist2[i][i] = 0;
  }
  for(int u = 0; u < n; u++){
    for(int v = u + 1; v < n; v++){
      if(dist[u][v] <= l){
        dist2[u][v] = 1;
        dist2[v][u] = 1;
      }
    }
  }
  for(int k = 0; k < n; k++){
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        dist2[i][j] = min(dist2[i][k] + dist2[k][j], dist2[i][j]);
      }
    }
  }

  string buf;
  for(int i = 0; i < q; i++){
    if(dist2[s[i] - 1][t[i] - 1] != INF_INT) buf += to_string(dist2[s[i] - 1][t[i] - 1] - 1);
    else buf += "-1";
    buf += "\n";
  }

  cout << buf;

  return 0;
}
