#include <iostream>
#include <vector>
#define MAX_X 100
#define MAX_Y 100
#define MAX_M (10000 + MAX_X + MAX_Y)
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

int X, Y, M;
vector< Edge > G[MAX_X + MAX_Y + 2];

void add_edge(int from, int to, int u){
  G[from].push_back(Edge(to, u, G[to].size()));
  G[to].push_back(Edge(from, 0, G[from].size() - 1));
}

bool visited[MAX_X + MAX_Y + 2];
int dfs(int v, int t){
  if(v == t){
    return 1;
  }

  visited[v] = true;
  for(int i = 0; i < G[v].size(); i++){
    Edge &e = G[v][i];
    if(!visited[e.to] && e.u == 1){
      int d = dfs(e.to, t);
      if(d == 1){
        e.u -= 1;
        G[e.to][e.rev].u += 1;
        return 1;
      }
    }
  }

  return 0;
}

int main(){
  cin >> X >> Y >> M;
  for(int i = 0; i < X; i++){
    add_edge(0, i + 1, 1);
  }
  for(int i = 0; i < Y; i++){
    add_edge(1 + X + i, 1 + X + Y, 1);
  }
  for(int i = 0; i < M; i++){
    int x, y;
    cin >> x >> y;
    x += 1; y += X + 1;
    add_edge(x, y, 1);
  }
  
  int s = 0, t = X + Y + 1, flow = 0;
  int count = 0;
  for(;;){
    fill(visited, visited + X + Y + 2, false);
    int f = dfs(s, t);
    if(f == 0){
      break;
    }
    flow += f;
    count++;
  }

  cout << flow << endl;

  return 0;
}
