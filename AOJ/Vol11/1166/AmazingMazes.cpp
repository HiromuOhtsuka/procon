#include <cstdio>
#include <climits>
#include <map>
#include <queue>
#define MAX_WH 32
using namespace std;

class Edge {
  public:
    int to;

    Edge(int to){
      this->to = to;
    }
};

static int W, H;
static bool G[MAX_WH][MAX_WH][MAX_WH][MAX_WH];
typedef pair< int, int > P;
static bool visited[MAX_WH][MAX_WH];

static int bfs(){
  queue< pair< P, int > > que;

  for(int i = 0; i < H; i++){
    for(int j = 0; j < W; j++){
      visited[i][j] = false;
    }
  }

  que.push(pair< P, int > (P(0, 0), 1));
  while(!que.empty()){
    pair< P, int >  p = que.front(); que.pop();
    P v = p.first;  int d = p.second;
    if(visited[v.second][v.first]){
      continue;
    }
    if(v.first == W - 1 && v.second == H - 1){
      return d;
    }
    visited[v.second][v.first] = true;
    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        if(G[v.second][v.first][i][j]){
          que.push(pair< P, int > (P(j, i), d + 1));
        }
      }
    }
  }

  return 0;
}

int main(){
  for(;;){
    scanf("%d %d", &W, &H);

    if(W == 0 && H == 0){
      return 0;
    }

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        if(i + 1 < H){
          G[i][j][i + 1][j] = true;
        }
        if(i - 1 >= 0){
          G[i][j][i - 1][j] = true;
        }
        if(j + 1 < W){
          G[i][j][i][j + 1] = true;
        }
        if(j - 1 >= 0){
          G[i][j][i][j - 1] = true;
        }
      }
    }

    int x = 0, y = 0;
    for(int i = 0; i < 2 * H - 1; i++){
      x = 0;
      if(i % 2 == 0){
        for(int j = 0; j < W - 1; j++){
          int m;
          scanf("%d", &m);
          if(m){
            G[y][x][y][x + 1] = G[y][x + 1][y][x] = false;
          }
          ++x;
        }
      }
      else{
        ++y;
        for(int j = 0; j < W; j++){
          int m;
          scanf("%d", &m);
          if(m){
            G[y][x][y - 1][x] = G[y - 1][x][y][x] = false;
          }
          ++x;
        }
      }
    }


    int ans = bfs();

    printf("%d\n", ans);

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        for(int k = 0; k < H; k++){
          for(int l = 0; l < W; l++){
            G[i][j][k][l] = false;
          }
        }
      }
    }
  }

  return 0;
}
