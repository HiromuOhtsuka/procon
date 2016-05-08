#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>
#define MAX_N 100
#define MAX_M 1000
#define INF INT_MAX
using namespace std;

class Edge {
  public:
    int to, u, rev;

  Edge(){}

  Edge(int to, int u, int rev){
    this->to = to;
    this->u = u;
    this->rev = rev;
  }
};

int N, M;
vector< Edge > G[MAX_N];

void add_edge(int from, int to, int u){
  G[from].push_back(Edge(to, u, G[to].size()));
  G[to].push_back(Edge(from, 0, G[from].size() - 1));
}

bool visited[MAX_N];
int dfs(int v, int t, int f){
  if(v == t){
    return f;
  }
  visited[v] = true;
  for(int i = 0; i < G[v].size(); i++){
    Edge &e = G[v][i];
    if(!visited[e.to] && e.u > 0){
      int d = dfs(e.to, t, min(f, e.u));
      if(d > 0){
        e.u -= d;
        G[e.to][e.rev].u += d;
        return d;
      }
    }
  }
  return 0;
}

int main(){
  cin >> N >> M;
  for(int i = 0; i < M; i++){
    int u, v, c;
    cin >> u >> v >> c;
    add_edge(u, v, c);
  }

  int s = 0, t = N - 1, flow = 0;
  for(;;){
    fill(visited, visited + N, false);
    int f = dfs(s, t, INF);
    if(f == 0){
      break;
    }
    flow += f;
  }
  cout << flow << endl;

  return 0;
}
