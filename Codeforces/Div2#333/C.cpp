#include <iostream>
#include <climits>
#include <algorithm>
#include <vector>
#include <queue>
#include <map>
#include <set>
#define MAX_N 400
using namespace std;

typedef pair< int, int > P;

class Edge {
  public :
    int from, to, cost;
    bool is_road;

  Edge(){}

  Edge(int from, int to, int cost, bool is_road){
    this->from = from;
    this->to = to;
    this->cost = cost;
    this->is_road = is_road;
  }

};

int N, M;
vector< Edge > G[MAX_N];
set< P > tmp;

int dist[MAX_N];
void dijkstra(int s, int t, bool road){
  priority_queue< P, vector< P >, greater< P > > que;

  fill(dist, dist + N, INT_MAX);
  dist[0] = 0;
  que.push(P(0, s));
  while(!que.empty()){
    P p = que.top(); que.pop();
    int d = p.first, v = p.second;
    if(dist[v] < d){
      continue;
    }
    dist[v] = d;
    for(int i = 0; i < G[v].size(); i++){
      Edge &e = G[v][i];
      if(e.is_road == road){
        que.push(P(d + e.cost, e.to));
      }
    }
  }
}

int main(){
  cin >> N >> M;
  for(int i = 0; i < M; i++){
    int u, v;
    cin >> u >> v;
    --u, --v;
    G[u].push_back(Edge(u, v, 1, false));
    G[v].push_back(Edge(v, u, 1, false));
  }
  for(int i = 0; i < N; i++){
    for(int j = 0; j < G[i].size(); j++){
      Edge &e = G[i][j];
      tmp.insert(P(e.from, e.to));
    }
  }
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      if(i == j){
        continue;
      }
      if(tmp.find(P(i, j)) == tmp.end() &&
         tmp.find(P(j, i)) == tmp.end()){
        G[i].push_back(Edge(i, j, 1, true));
        G[j].push_back(Edge(j, i, 1, true));
      }
    }
  }

  int d1, d2;
  dijkstra(0, N - 1, false);
  d1 = dist[N - 1];
  dijkstra(0, N - 1, true);
  d2 = dist[N - 1];

  if(d1 == INT_MAX || d2 == INT_MAX){
    cout << -1 << endl;
  }
  else{
    cout << max(d1, d2) << endl;
  }
  
  return 0;
}
