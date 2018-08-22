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
using namespace std;

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
  return 0;
}
