#include <cstdio>
#include <climits>
#include <vector>
#define INF INT_MAX
#define MAX_N 1000
#define MAX_M 2000
using namespace std;

class Edge {
  public:
    int from, to, cost;

  Edge(int from, int to, int cost){
    this->from = from;
    this->to = to;
    this->cost = cost;
  }
};

int N, M, R;
vector< Edge > G;
int dist[MAX_N];

bool bellman_ford(int s){
  fill(dist, dist + N, INF);

  dist[s] = 0;
  for(int i = 0; i < N; i++){
    bool update = false;
    for(int j = 0; j < M; j++){
      Edge e = G[j];
      if(dist[e.from] != INF && dist[e.to] > dist[e.from] + e.cost){
        dist[e.to] = dist[e.from] + e.cost;
        update = true;
      }
    }
    if(!update){
      break;
    }
    if(i == N - 1){
      return false;
    }
  }

  return true;
}

int main(){
  scanf("%d %d %d", &N, &M, &R);
  for(int i = 0; i < M; i++){
    int s, t, d;
    scanf("%d %d %d", &s, &t, &d);
    G.push_back(Edge(s, t, d));
  }

  if(bellman_ford(R)){
    for(int i = 0; i < N; i++){
      if(dist[i] != INF){
        printf("%d\n", dist[i]);
      }
      else{
        printf("INF\n");
      }
    }
  }
  else{
    printf("NEGATIVE CYCLE\n");
  }

  return 0;
}
