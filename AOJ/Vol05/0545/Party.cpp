#include <cstdio>
#include <vector>
#include <map>
#include <queue>
#define MAX_N 500
#define MAX_M 10000
using namespace std;

int N, M;
vector< int > G[MAX_N];
bool visited[MAX_N];
typedef pair< int, int > P;

int main(){
  for(;;){
    scanf("%d %d", &N, &M);

    if(N == 0 && M == 0){
      return 0;
    }

    for(int i = 0; i < M; i++){
      int a, b;
      scanf("%d %d", &a, &b);
      --a, --b;
      G[a].push_back(b);
      G[b].push_back(a);
    }

    int count = 0;
    queue< P > que;
    que.push(P(0, 0));
    while(!que.empty()){
      P p = que.front();  que.pop();
      int n = p.first, d = p.second;
      if(d == 3 || visited[n]){
        continue;
      }
      visited[n] = true;
      ++count;
      for(int i = 0; i < G[n].size(); i++){
        que.push(P(G[n][i], d + 1));
      }
    }

    printf("%d\n", count - 1);

    for(int i = 0; i < N; i++){
      G[i].clear();
      visited[i] = false;
    }

  }

  return 0;
}
