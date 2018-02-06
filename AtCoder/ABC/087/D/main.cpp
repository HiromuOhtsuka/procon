#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <tuple>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
#define MAX_M 200000
using namespace std;

class edge{
  public:
    int u, v, c;
    edge(int u, int v, int c): u(u), v(v), c(c){}
    edge(){}
};

vector< edge > graph[MAX_N];

void dfs(int v, int x[], bool visited[]){
  visited[v] = true;
  for(edge e: graph[v]){
    int w = e.v;
    if(!visited[w]){
      x[w] = x[v] + e.c;
      dfs(w, x, visited);
    }
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int l[MAX_M], r[MAX_M], d[MAX_M];
  for(int i = 0; i < m; i++){
    cin >> l[i] >> r[i] >> d[i];
    --l[i]; --r[i];
  }

  if(m == 0){
    cout << "Yes" << endl;
    return 0;
  }

  for(int i = 0; i < m; i++){
    graph[l[i]].push_back(edge(l[i], r[i], d[i]));
    graph[r[i]].push_back(edge(r[i], l[i], -d[i]));
  }

  int x[n];
  fill(x, x + n, -1);
  bool visited[n];
  fill(visited, visited + n, false);
  for(int s = 0; s < n; s++){
    if(!visited[s]){
      x[s] = 0;
      dfs(s, x, visited);
    }
  }

  bool exist = true;
  for(int i = 0; i < m; i++){
    if(x[r[i]] - x[l[i]] != d[i]){
      exist = false; break;
    }
  }

  if(exist) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
