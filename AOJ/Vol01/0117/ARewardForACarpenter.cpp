#include <cstdio>
#include <vector>
#include <queue>
#include <map>
#include <climits>
#define MAX_N 20
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

static vector< Edge > G[MAX_N];
static int N, M, X1, X2, Y1, Y2;
typedef pair< int, int > P;
static int dist[MAX_N];
static int search(int from, int to){
  priority_queue< P, vector< P >, greater< P > > pq;

  for(int i = 0; i < N; i++){
    dist[i] = INT_MAX;
  }

  pq.push(P(0, from));
  while(!pq.empty()){
    P p = pq.top(); pq.pop();
    int v = p.second, cost = p.first;
    if(dist[v] < cost){
      continue;
    }
    dist[v] = cost;
    for(int i = 0; i < G[v].size(); i++){
      pq.push(P(cost + G[v][i].cost, G[v][i].to));
    }
  }

  return dist[to];
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int a1, b1, c1, d1;
    scanf("%d,%d,%d,%d", &a1, &b1, &c1, &d1);
    --a1; --b1;
    G[a1].push_back(Edge(a1, b1, c1));
    G[b1].push_back(Edge(b1, a1, d1));
  }
  scanf("%d,%d,%d,%d", &X1, &X2, &Y1, &Y2);
  --X1; --X2;
  int cost1 = search(X1, X2), cost2 = search(X2, X1);
  int yen = Y1 - (cost1 + cost2 + Y2);

  printf("%d\n", yen);

  return 0;
}
