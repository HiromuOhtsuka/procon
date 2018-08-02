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

void dfs(int v, bool visited[]){
  if(visited[v]) return;
  visited[v] = true;
  for(int w: graph[v]) dfs(w, visited);
}

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

  vector< int > s[MAX_M];
  for(int i = 0; i < n; i++){
    for(int j = 0; j < k[i]; j++){
      s[l[i][j]].push_back(i);
    }
  }

  for(int v = 0; v < n; v++){
    for(int i = 0; i < k[v]; i++){
      for(int w: s[l[v][i]]){
        if(v < w){
          graph[v].push_back(w);
          graph[w].push_back(v);
        }
      }
    }
  }

  bool visited[n];
  fill(visited, visited + n, false);
  dfs(0, visited);

  for(int v = 0; v < n; v++){
    if(!visited[v]){
      cout << "NO" << endl;
      return 0;
    }
  }

  cout << "YES" << endl;

  return 0;
}
