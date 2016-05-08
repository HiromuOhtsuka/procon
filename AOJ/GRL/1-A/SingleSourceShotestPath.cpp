#include <cstdio>
#include <climits>
#include <vector>
#include <queue>
#include <map>
#define MAX_N 100000
#define MAX_M 500000
#define INF INT_MAX
using namespace std;

class Edge {
  public:
    int to, cost;

  Edge(int to, int cost){
    this->to = to;
    this->cost = cost;
  }
};

int N, M, R;
vector< Edge > G[MAX_N];

typedef pair< int, int > P;
int dist[MAX_N];
void dijkstra(int s){
  priority_queue< P, vector< P >, greater< P > > pq;

  fill(dist, dist + N, INF);

  pq.push(P(s, 0));
  dist[s] = 0;
  while(!pq.empty()){
    P p = pq.top(); pq.pop();
    int v = p.first, d = p.second;
    if(d > dist[v]){
      continue;
    }
    dist[v] = d;
    for(int i = 0; i < G[v].size(); i++){
      Edge e = G[v][i];
      pq.push(P(e.to, d + e.cost));
    }
  }
}

int main(){
  scanf("%d %d %d", &N, &M, &R);
  for(int i = 0; i < M; i++){
    int s, t, d;
    scanf("%d %d %d", &s, &t, &d);
    G[s].push_back(Edge(t, d));
  }

  dijkstra(R);

  for(int i = 0; i < N; i++){
    if(dist[i] != INF){
      printf("%d\n", dist[i]);
    }
    else{
      printf("INF\n");
    }
  }

  return 0;
}
