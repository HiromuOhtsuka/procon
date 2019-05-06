#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <deque>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int h, w;
  cin >> h >> w;
  vector< string > a(h);
  for(int i = 0; i < h; i++) cin >> a[i];

  int dist[h][w];
  for(int i = 0; i < h; i++){
    fill(dist[i], dist[i] + w, INF_INT);
  }

  queue< pii > q;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(a[i][j] == '#'){
        q.push(make_pair(i, j));
        dist[i][j] = 0;
      }
    }
  }

  int dx[] = {0, 1, 0, -1}, 
      dy[] = {-1, 0, 1, 0};

  while(!q.empty()){
    pii p = q.front();  q.pop();
    for(int i = 0; i < 4; i++){
      int ny = p.first + dy[i];
      int nx = p.second + dx[i];
      if(!(0 <= ny && ny < h && 0 <= nx && nx < w)) continue;
      if(a[ny][nx] == '.'){
        a[ny][nx] = '#';
        dist[ny][nx] = dist[p.first][p.second] + 1;
        q.push(make_pair(ny, nx));
      }
    }
  }

  int ans = 0;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      ans = max(ans, dist[i][j]);
    }
  }

  cout << ans << endl;

  return 0;
}
