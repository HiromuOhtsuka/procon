#include <iostream>
#include <algorithm>
#include <vector>
#include <cmath>
#include <climits>
#include <cstring>
#define MAX_N 100
#define MAX_M 1000
using namespace std;

int N, M;
class Edge {
  public:
    int to, cap, rev;
  Edge(int to, int cap, int rev){
    this->to = to;
    this->cap = cap;
    this->rev = rev;
  }
};

vector< Edge > G[MAX_N];
bool used[MAX_N];

int dfs(int s, int t, int d){
  if(s == t){
    return d;
  }
  used[s] = true;
  for(int i = 0; i < G[s].size(); i++){
    Edge& e = G[s][i];
    if(!used[e.to] && e.cap > 0){
      int c = dfs(e.to, t, min(d, e.cap));
      if(c > 0){
        e.cap -= c;
        G[e.to][e.rev].cap += c;
        return c;
      }
    }
  }
  return 0;
}

void add_edge(int from, int to, int cap){
  G[from].push_back(Edge(to, cap, G[to].size()));
  G[to].push_back(Edge(from, 0, G[from].size() - 1));
}

int main(){
  cin >> N >> M;
  for(int i = 0; i < M; i++){
    int u, v, c;
    cin >> u >> v >> c;
    add_edge(u, v, c);
  }

  int sum = 0;
  for(;;){
    memset(used, false, N);
    int f = dfs(0, N - 1, INT_MAX);
    if(f == 0){
      break;
    }
    sum += f;
  }

  cout << sum << endl;

  return 0;
}
