#include <cstdio>
#include <queue>
#include <map>
#include <vector>
#define MAX_N 100
using namespace std;

static int N, G[MAX_N][MAX_N];
typedef pair< int, int > P;
static priority_queue< P, vector< P >, greater< P > > pq;
static bool visited[MAX_N];

int main(){
  scanf("%d", &N);
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      scanf("%d", &G[i][j]);
    }
  }

  int cost = 0;
  pq.push(P(0, 0));
  while(!pq.empty()){
    P p = pq.top();  pq.pop();
    int w = p.second;
    if(visited[w]){
      continue;
    }
    cost += p.first;
    visited[w] = true;
    for(int i = 0; i < N; i++){
      if(G[w][i] != -1){
        pq.push(P(G[w][i], i));
      }
    }
  }

  printf("%d\n", cost);

  return 0;
}
