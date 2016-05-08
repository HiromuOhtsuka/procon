#include <iostream>
#include <cstdio>
#include <queue>
#include <map>
#define MAX_R 50
#define MAX_C 50
using namespace std;

typedef pair< int, int > P;

int R, C;
int sx, sy;
int gx, gy;
char table[MAX_R][MAX_C];

int dist[MAX_R][MAX_C];
int bfs(){
  static const int dx[] = { -1, 0, 0, 1},
    dy[] = {0, -1, 1, 0};
  queue< P > que;

  que.push(P(sx, sy));
  while(!que.empty()){
    P p = que.front(); que.pop();
    int x = p.first, y = p.second;
    if(x == gx && y == gy){
      break;
    }
    for(int i = 0; i < 4; i++){
      if((0 <= (x + dx[i]) && (x + dx[i]) < C 
          && 0 <= (y + dy[i]) && (y + dy[i]) < R) 
        && table[y + dy[i]][x + dx[i]] == '.' 
        && dist[y + dy[i]][x + dx[i]] == 0){
        dist[y + dy[i]][x + dx[i]] = dist[y][x] + 1;
        que.push(P(x + dx[i], y + dy[i]));
      }
    }
  }
  return dist[gy][gx];
}

int main(){
  cin >> R >> C;
  cin >> sy >> sx;
  cin >> gy >> gx;

  for(int i = 0; i < R; i++){
    getchar();
    for(int j = 0; j < C; j++){
      cin >> table[i][j];
    }
  }

  sx--, sy--, gx--, gy--;
  int ans = bfs();
  cout << ans << endl;

  return 0;
}
