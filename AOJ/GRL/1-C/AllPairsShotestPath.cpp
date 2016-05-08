#include <cstdio>
#include <climits>
#include <vector>
#define MAX_N 100
#define MAX_M 9900
#define INF INT_MAX
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

int N, M;
vector< Edge > G[MAX_N];

int dist[MAX_N][MAX_N];
bool floyd_warshall(){
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      dist[i][j] = (i != j) ? INF : 0;
    }
  }

  for(int i = 0; i < N; i++){
    for(int j = 0; j < G[i].size(); j++){
      int from = G[i][j].from, to = G[i][j].to, cost = G[i][j].cost;
      dist[from][to] = cost;
    }
  }

  for(int j = 0; j < N; j++){
    for(int i = 0; i < N; i++){
      for(int k = 0; k < N; k++){
        if(dist[i][j] != INF && dist[j][k] != INF
            && dist[i][k] > dist[i][j] + dist[j][k]){
          dist[i][k] = dist[i][j] + dist[j][k];
        }
      }
    }
  }

  for(int i = 0; i < N; i++){
    if(dist[i][i] < 0){
      return false;
    }
  }

  return true;
}

int main(){
  scanf("%d %d", &N, &M);
  for(int i = 0; i < M; i++){
    int s, t, d;
    scanf("%d %d %d", &s, &t, &d);
    G[s].push_back(Edge(s, t, d));
  }

  if(floyd_warshall()){
    for(int i = 0; i < N; i++){
      for(int j = 0; j < N; j++){
        if(dist[i][j] == INF){
          printf("INF%c", (j == N - 1) ? '\n' : ' ');
        }
        else{
          printf("%d%c", dist[i][j], (j == N - 1) ? '\n' : ' ');
        }
      }
    }
  }
  else{
    printf("NEGATIVE CYCLE\n");
  }

  return 0;
}
