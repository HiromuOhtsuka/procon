#include <cstdio>
#include <vector>
#include <stack>
#include <map>
#define MAX_N 100
using namespace std;

class Edge {
  public :
    int from, to;

    Edge(int from, int to){
      this->from = from;
      this->to = to;
    }
};

static int N;
static vector< Edge > G[MAX_N];
static bool visited[MAX_N];
static int best;

static void dfs(int v, int cost){
  if(cost > best){
    best = cost;
  }
  visited[v] = true;
  for(int i = 0; i < G[v].size(); i++){
    int to = G[v][i].to;
    if(visited[to]){
      continue;
    }
    dfs(to, cost + 1);
    visited[to] = false;
  }
}

int main(){
  for(;;){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      int a, b;
      scanf("%d %d", &a, &b);
      --a; --b;
      G[a].push_back(Edge(a, b));
      G[b].push_back(Edge(b, a));
    }

    int ans = 0;
    for(int s = 0; s < MAX_N; s++){
      if(G[s].size() != 0){
        fill(visited, visited + MAX_N, false);
        best = 1;
        dfs(s, 1);
        ans = max(ans, best);
      }
    }

    printf("%d\n", ans);

    for(int i = 0; i < MAX_N; i++){
      G[i].clear();
    }
  }

  return 0;
}
