#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef pair< int, int > pii;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int h, w;
  cin >> h >> w;
  bool c[h][w];
  for(int i = 0; i < h; i++){
    string line;
    cin >> line;
    for(int j = 0; j < w; j++){
      if(line[j] == '#') c[i][j] = true;
      else c[i][j] = false;
    }
  }

  int black = 0;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(c[i][j]) ++black;
    }
  }

  int dist[h][w];
  for(int i = 0; i < h; i++){
    fill(dist[i], dist[i] + w, INF_INT);
  }

  int dx[4] = {0, 1, 0, -1};
  int dy[4] = {-1, 0, 1, 0};

  queue< pii > q;

  q.push(make_pair(0, 0));
  dist[0][0] = 0;
  while(!q.empty()){
    pii p = q.front(); q.pop();
    int i = p.second, j = p.first;
    for(int k = 0; k < 4; k++){
      int ni = i + dy[k];
      int nj = j + dx[k];
      if(!((0 <= ni && ni < h) &&
        (0 <= nj && nj < w)))
        continue;
      if(c[ni][nj]) continue;
      if(dist[ni][nj] == INF_INT){
        dist[ni][nj] = dist[i][j] + 1;
        q.push(make_pair(nj, ni));
      }
    }
  }

  if(dist[h - 1][w - 1] == INF_INT){
    cout << -1 << endl;
    return 0;
  }

  int ans = (h * w) - (black + dist[h - 1][w - 1]) - 1;
  cout << ans << endl;

  return 0;
}
