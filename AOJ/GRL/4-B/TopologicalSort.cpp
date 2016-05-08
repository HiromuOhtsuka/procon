#include <cstdio>
#include <vector>
#include <queue>
#include <list>
#define MAX_N 10000
#define MAX_M 100000
using namespace std;

int N, M;
class Edge {
  public :
    int to;

  Edge(int to){
    this->to = to;
  }
};

vector< Edge > G[MAX_N];
bool visited[MAX_N];
int indegree[MAX_N];
list< int > order;

void bfs(int s){
  queue< int > que;

  que.push(s);
  while(!que.empty()){
    int v = que.front(); que.pop();
    visited[v] = true;
    order.push_back(v);
    for(int i = 0; i < G[v].size(); i++){
      Edge e = G[v][i];
      --indegree[e.to];
      if(indegree[e.to] == 0){
        que.push(e.to);
      }
    }
  }
}

void topological_sort(){
  for(int i = 0; i < N; i++){
    visited[i] = false;
    indegree[i] = 0;
  }
  for(int i = 0; i < N; i++){
    for(int j = 0; j < G[i].size(); j++){
      Edge e = G[i][j];
      indegree[e.to]++;
    }
  }

  for(int s = 0; s < N; s++){
    if(!visited[s] && indegree[s] == 0){
      bfs(s);
    }
  }
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    G[s].push_back(Edge(t));
  }
  topological_sort();

  list< int >::iterator it = order.begin();
  while(it != order.end()){
    printf("%d\n", *it);
    ++it;
  }

  return 0;
}
