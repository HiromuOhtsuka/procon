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
#define MAX_R 40
#define MAX_C 40
using namespace std;

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

class BipatateMatching{
  public:
    int n;
    vector< vector< int > > graph;
    vector< int > match;
    vector< bool > visited;

    BipatateMatching(int n):
      n(n), graph(n), match(n), visited(n){}

    void add_edge(int u, int v){
      graph[u].push_back(v);
      graph[v].push_back(u);
    }

    bool dfs(int u){
      visited[u] = true;
      for(int v: graph[u]){
        int w = match[v];
        if(w == -1 || (!visited[w] && dfs(w))){
          match[u] = v;
          match[v] = u;
          return true;
        }
      }
      return false;
    }

    int solve(){
      int result = 0;
      fill(match.begin(), match.end(), -1);
      for(int v = 0; v < n; v++){
        if(match[v] == -1){
          fill(visited.begin(), visited.end(), false);
          if(dfs(v)) ++result;
        }
      }
      return result;
    }
};

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int r, c;
  cin >> r >> c;
  string s[MAX_R];
  for(int i = 0; i < r; i++) cin >> s[i];

  BipatateMatching bm(r * c);
  int n = 0;
  for(int i = 0; i < r; i++){
    for(int j = 0; j < c; j++){
      if(s[i][j] == '*') continue;
      if(j + 1 < c && s[i][j + 1] == '.'){
        bm.add_edge(c * i + j, c * i + j + 1);
      }
      if(i + 1 < r && s[i + 1][j] == '.'){
        bm.add_edge(c * i + j, c * (i + 1) + j);
      }
      ++n;
    }
  }

  int ans = n - bm.solve();

  cout << ans << endl;

  return 0;
}
