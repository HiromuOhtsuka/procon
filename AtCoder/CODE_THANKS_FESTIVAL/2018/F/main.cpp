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
#define MAX_N 301
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

vector< int > graph[MAX_N];

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

void dfs(int v, int p, int d, 
    int depth[], vector< vector< int > >& depths){
  depth[v] = d;
  depths[d].push_back(v);
  for(int w: graph[v]){
    if(w != p) dfs(w, v, d + 1, depth, depths);
  }
}

void dfs2(int v, int p, bool chosen[]){
  if(chosen[v]) return;
  chosen[v] = true;
  for(int w: graph[v]){
    if(w != p) dfs2(w, v, chosen);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m, k;
  cin >> n >> m >> k;
  int p[n + 1];
  for(int i = 1; i <= n; i++) cin >> p[i];

  for(int v = 1; v <= n; v++){
    int w = p[v];
    if(w == 0) continue;
    graph[v].push_back(w);
    graph[w].push_back(v);
  }

  int r = -1;
  for(int i = 1; i <= n; i++){
    if(p[i] == 0){
      r = i;
      break;
    }
  }

  int d[n];
  vector< vector< int > > depths(MAX_N + 1);
  dfs(r, -1, 1, d, depths);

  int a[m];
  int sum = 0;

  bool chosen[n + 1];
  bool tmp_chosen[n + 1];
  fill(chosen, chosen + n + 1, false);

  bool ok = true;
  for(int i = 0; i < m; i++){
    bool found = false;
    for(int v = 1; v <= n; v++){
      if(chosen[v]) continue;

      fill(tmp_chosen, tmp_chosen + n + 1, false);
      dfs2(v, p[v], tmp_chosen);

      int count = 0;
      for(int w = 1; w <= n; w++){
        if(!chosen[w] && !tmp_chosen[w]){
          ++count;
        }
      }

      int mm = (m - (i + 1));
      if(count < mm) continue;

      int target = k - sum - d[v];
      int s = 0;
      count = 0;
      for(int j = 1; j <= n && count < mm; j++){
        for(int w: depths[j]){
          if(!chosen[w] && !tmp_chosen[w]){
            s += j;
            ++count;
            if(count >= mm) break;
          }
        }
      }

      if(target < s){
        continue;
      }

      s = count = 0;
      for(int j = n; j >= 1 && count < mm; j--){
        for(int w: depths[j]){
          if(!chosen[w] && !tmp_chosen[w]){
            s += j;
            ++count;
            if(count >= mm) break;
          }
        }
      }

      if(target > s){
        continue;
      }

      a[i] = v;
      sum += d[v];
      for(int v = 1; v <= n; v++){
        if(tmp_chosen[v]) chosen[v] = true;
      }

      found = true;
      break;
    }
    if(!found){
      ok = false;
      break;
    }
  }

  string buf;
  if(!ok) buf += to_string(-1);
  else{
    for(int i = 0; i < m; i++){
      buf += to_string(a[i]) + " ";
    }
  }

  cout << buf << endl;

  return 0;
}
