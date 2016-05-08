#include <cstdio>
#include <queue>
#include <map>
#define MAX_H 1000
#define MAX_W 1000
#define MAX_N 9
using namespace std;

typedef pair< int, int > Point;

int H, W, N;
char table[MAX_H][MAX_W];

bool visited[MAX_H][MAX_W];
Point current;
int best;
void bfs(Point s, int n){
  static const int dx[] = {0, 0, -1, 1},
                   dy[] = {-1, 1, 0, 0};
  queue< pair< Point, int > > que;

  for(int i = 0; i < H; i++){
    for(int j = 0; j < W; j++){
      visited[i][j] = false;
    }
  }

  que.push(pair< Point, int > (s, 0));
  while(!que.empty()){
    pair< Point, int > p = que.front(); que.pop();
    Point pp = p.first;
    if(visited[pp.second][pp.first]){
      continue;
    }
    if(table[pp.second][pp.first] == (char)n + '0'){
      best = p.second;
      current = pp;
      break;
    }
    visited[pp.second][pp.first] = true;
    for(int i = 0; i < 4; i++){
      Point ppp (pp.first + dx[i], pp.second + dy[i]);
      if(0 <= ppp.first && ppp.first < W &&
         0 <= ppp.second && ppp.second < H &&
         table[ppp.second][ppp.first] != 'X'){
        que.push(pair< Point, int > (ppp, p.second + 1));
      }
    }
  }
}

int main(){
  scanf("%d %d %d", &H, &W, &N);
  getchar();
  Point s;
  for(int i = 0; i < H; i++){
    for(int j = 0; j <= W; j++){
      int ch = getchar();
      if(ch == '\n'){
        continue;
      }
      table[i][j] = ch;
      if(ch == 'S'){
        s.first = j; s.second = i;
      }
    }
  }

  int time = 0;
  for(int i = 1; i <= N; i++){
    bfs(s, i);
    time += best;
    s = current;
  }

  printf("%d\n", time);

  return 0;
}
