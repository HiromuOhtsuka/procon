#include <cstdio>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
#define MAX_N 100000
#define MAX_M 100000
using namespace std;

typedef pair< int, int > Edge;
int N, M;
vector< Edge > G[MAX_N];

set< Edge > brs;
bool visited[MAX_N];
int parent[MAX_N], order[MAX_N], lowlink[MAX_N], order_num;
void dfs(int v, int pv){
  ++order_num;
  order[v] = lowlink[v] = order_num;

  visited[v] = true;
  for(int i = 0; i < G[v].size(); i++){
    Edge e = G[v][i];
    int from = e.first, to = e.second;
    if(!visited[to]){
      parent[to] = v;
      dfs(to, v);
      lowlink[v] = min(lowlink[v], lowlink[to]);
    }
    else if(to != pv){
      lowlink[v] = min(lowlink[v], order[to]);
    }
  }
}

void briges(){
  fill(visited, visited + N, false);
  order_num = 0;
  dfs(0, -1);

  for(int i = 0; i < N; i++){
    for(int j = 0; j < G[i].size(); j++){
      Edge e = G[i][j];
      int from = e.first, to = e.second;
      if(order[from] < lowlink[to]){
        if(from < to){
          brs.insert(Edge(from, to));
        }
        else{
          brs.insert(Edge(to, from));
        }
      }
    }
  }
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    G[s].push_back(Edge(s, t));
    G[t].push_back(Edge(t, s));
  }

  briges();

  set< Edge >::iterator it = brs.begin();
  while(it != brs.end()){
    int from = (*it).first, to = (*it).second;
    printf("%d %d\n", from, to);
    ++it;
  }

  return 0;
}

