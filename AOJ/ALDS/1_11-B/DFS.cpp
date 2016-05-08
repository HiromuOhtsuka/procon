#include <cstdio>
#include <vector>
#define MAX_N 100
using namespace std;

class Edge {
  public :
    int to;

  Edge(int to){
    this->to = to;
  }
};

int N;
vector< Edge > G[MAX_N];

int D[MAX_N], F[MAX_N], timer;
bool visited[MAX_N];
void dfs(int v){
  if(visited[v]){
    return;
  }

  ++timer;
  visited[v] = true;
  D[v] = timer;

  for(int i = 0; i < G[v].size(); i++){
    int w = G[v][i].to;
    dfs(w);
  }

  ++timer;
  F[v] = timer;
}

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    int u, k;
    scanf("%d %d", &u, &k);
    --u;
    for(int j = 0; j < k; j++){
      int v;
      scanf("%d", &v);
      --v;
      G[u].push_back(Edge(v));
    }
  }

  for(int i = 0; i < N; i++){
    if(!visited[i]){
      dfs(i);
    }
  }

  for(int i = 0; i < N; i++){
    printf("%d %d %d\n", i + 1, D[i], F[i]);
  }

  return 0;
}
