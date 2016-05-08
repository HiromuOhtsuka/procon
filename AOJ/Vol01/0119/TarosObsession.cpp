#include <cstdio>
#include <vector>
#include <list>
#include <queue>
#define MAX_M 20
#define MAX_N 100
using namespace std;

int M, N;
vector< int > G[MAX_M];
bool visited[MAX_M];
int indegree[MAX_M];
list< int > order;

void bfs(int s){
  queue< int > que;

  que.push(s);
  while(!que.empty()){
    int v = que.front(); que.pop();
    if(visited[v]){
      continue;
    }
    visited[v] = true;
    order.push_back(v);
    for(int i = 0; i < G[v].size(); i++){
      int t = G[v][i];
      indegree[t]--;
      if(indegree[t] == 0){
        que.push(t);
      }
    }
  }
}

void topological_order(){
  for(int i = 0; i < M; i++){
    for(int j = 0; j < G[i].size(); j++){
      indegree[G[i][j]]++;
    }
  }

  for(int i = 0; i < M; i++){
    if(!visited[i] && indegree[i] == 0){
      bfs(i);
    }
  }
}

int main(){
  scanf("%d %d", &M, &N);
  for(int i = 0; i < N; i++){
    int x, y;
    scanf("%d %d", &x, &y);
    --y, --x;
    G[x].push_back(y);
  }

  topological_order();

  list< int >::iterator it = order.begin();
  while(it != order.end()){
    printf("%d\n", *it + 1);
    ++it;
  }

  return 0;
}
