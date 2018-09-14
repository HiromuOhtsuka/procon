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

int rev(int x){
  int result = 0;
  while(x != 0){
    result = 10 * result + (x % 10);
    x /= 10;
  }
  return result;
}

pii g(pii p){
  int x = p.first, y = p.second;
  if(x == 0 || y == 0)
    return make_pair(-1, -1);
  if(x < y) x = rev(x);
  else y = rev(y);
  if(x < y) y = y - x;
  else x = x - y;
  return make_pair(x, y);
}

vector< int > graph[MAX_N * MAX_N];
bool visited[MAX_N * MAX_N];

void dfs(int v, bool visited[]){
  if(visited[v]) return;
  visited[v] = true;
  for(int w: graph[v]){
    dfs(w, visited);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;

  for(int i = 0; i < MAX_N; i++){
    for(int j = 0; j < MAX_N; j++){
      pii p = g(make_pair(i, j));
      if(p.first == -1) continue;
      int v = i * MAX_N + j;
      int w = p.first * MAX_N + p.second;
      graph[w].push_back(v);
    }
  }

  fill(visited, visited + MAX_N * MAX_N, false);
  for(int i = 0; i <= MAX_N; i++){
    dfs(i * MAX_N, visited);
    dfs(i, visited);
  }

  int count = 0;
  for(int i = 1; i <= n; i++){
    for(int j = 1; j <= m; j++){
      int v = i * MAX_N + j;
      if(visited[v]) ++count;
    }
  }

  int ans = n * m - count;

  cout << ans << endl;

  return 0;
}
