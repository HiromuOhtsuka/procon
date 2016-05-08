#include <cstdio>
#include <climits>
#include <vector>
#include <set>
#include <algorithm>
#define MAX_N 100000
#define MAX_M 100000
#define INF INT_MAX
using namespace std;

class Edge {
  public :
    int to;

  Edge(int to){
    this->to = to;
  }
};

int N, M;
vector< Edge > G[MAX_N];

set< int > ap;
int prenum[MAX_N], parent[MAX_N], lowest[MAX_N], order;
bool visited[MAX_N];
void dfs(int v, int pv){
  ++order;
  prenum[v] = lowest[v] = order;

  visited[v] = true;

  for(int i = 0; i < G[v].size(); i++){
    Edge e = G[v][i];
    if(!visited[e.to]){
      parent[e.to] = v;
      dfs(e.to, v);
      lowest[v] = min(lowest[v], lowest[e.to]);
    }
    else if(e.to != pv){
      lowest[v] = min(lowest[v], prenum[e.to]);
    }
  }

}
void artical_points(){
  fill(visited, visited + N, false);
  order = 0;

  dfs(0, -1);

  int ind = 0;
  for(int i = 1; i < N; i++){
    int p = parent[i];
    if(p == 0){
      ++ind;
    }
    else if(prenum[p] <= lowest[i]){
      ap.insert(p);
    }
  }
  if(ind >= 2){
    ap.insert(0);
  }
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t;
    scanf("%d %d", &s, &t);
    G[s].push_back(Edge(t));
    G[t].push_back(Edge(s));
  }

  artical_points();

  set< int >::iterator it = ap.begin();
  while(it != ap.end()){
    printf("%d\n", *it);
    ++it;
  }

  return 0;
}
