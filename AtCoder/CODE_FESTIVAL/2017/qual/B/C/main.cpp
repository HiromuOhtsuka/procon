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

vector< int > graph[MAX_N];

bool dfs(int v, int c, int color[]){
  if(color[v] >= 0) return color[v] == c;
  color[v] = c;
  for(int w: graph[v]){
    if(!dfs(w, c ? 0 : 1, color)) return false;
  }
  return true;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[m], b[m];
  for(int i = 0; i < m; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }

  for(int i = 0; i < m; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }

  int color[n];
  fill(color, color + n, -1);

  ll ans;
  if(!dfs(0, 0, color)){
    ans = (ll)n * (n - 1) / 2 - m;
  }
  else{
    int count = 0;
    for(int v = 0; v < n; v++){
      if(color[v] == 0) ++count;
    }
    ans = (ll)count * (n - count) - m;
  }

  cout << ans << endl;

  return 0;
}
