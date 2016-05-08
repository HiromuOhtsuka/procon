#include <cstdio>
#include <vector>
#include <climits>
#include <queue>
#include <functional>
#define MAX_N 128
using namespace std;

class Edge {
  public :
    int from, to, cost;
    Edge(int from, int to, int cost){
      this->from = from;
      this->to = to;
      this->cost = cost;
    }
};

static int N, K;
static vector< Edge > G[MAX_N];
static int dijkstra(int start, int end);

int main(){
  while(true){
    scanf("%d %d", &N, &K);
    if(N == 0 && K == 0){
      return 0;
    }
    for(int i = 0; i < K; i++){
      int n;
      scanf("%d", &n);
      if(n == 0){
        int a, b;
        scanf("%d %d", &a, &b);
        int cost = dijkstra(a - 1, b - 1);
        printf("%d\n", cost);
      }
      else if(n == 1){
        int  c, d, e;
        scanf("%d %d %d", &c, &d, &e);
        G[c - 1].push_back(Edge(c - 1, d - 1, e));
        G[d - 1].push_back(Edge(d - 1, c - 1, e));
      }
    }

    for(int i = 0; i < N; i++){
      G[i].clear();
    }

  }

  return 0;
}

static int dijkstra(int start, int end){
  static int dist[MAX_N];

  for(int i = 0; i < N; i++){
    dist[i] = INT_MAX;
  }
  dist[start] = 0;

  priority_queue< pair< int, int >, vector< pair< int, int > >, greater< pair< int, int > > > pq;
  pq.push(pair< int, int >(0, start));
  while(!pq.empty()){
    pair< int, int > p = pq.top();  pq.pop();
    int d = p.first, from = p.second;
    if(dist[from] < d){
      continue;
    }
    for(int i = 0; i < G[from].size(); i++){
      int cost = d + G[from][i].cost,
          to = G[from][i].to;
      if(dist[to] > cost){
        dist[to] = cost;
        pq.push(pair< int, int >(cost, to));
      }
    }
  }

  if(dist[end] == INT_MAX){
    return -1;
  }
  else{
    return dist[end];
  }
}
