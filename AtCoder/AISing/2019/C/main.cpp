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
#define MAX_H 400
#define MAX_W 400
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int h, w;
string s[MAX_H];

int color[MAX_H][MAX_W];

void dfs(int i, int j, int c){
  if(color[i][j] != 0) return;
  color[i][j] = c;
  int di[] = {0, -1, 0, 1};
  int dj[] = {1, 0, -1, 0};
  for(int k = 0; k < 4; k++){
    int ni = i + di[k];
    int nj = j + dj[k];
    if(!(ni >= 0 && ni < h && nj >= 0 && nj < w))
      continue;
    if((s[i][j] == '#' && s[ni][nj] == '.') ||
        (s[i][j] == '.' && s[ni][nj] == '#'))
      dfs(ni, nj, c);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> h >> w;
  for(int i = 0; i < h; i++) cin >> s[i];

  int c = 0;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(color[i][j] == 0){
        dfs(i, j, ++c);
      }
    }
  }

  ll counts[c][2];
  for(int i = 0; i < c; i++){
    fill(counts[i], counts[i] + 2, 0);
  }

  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(s[i][j] == '#') counts[color[i][j] - 1][0]++;
      else if(s[i][j] == '.') counts[color[i][j] - 1][1]++;
    }
  }

  ll sum = 0;
  for(int i = 0; i < c; i++){
    sum += counts[i][0] * counts[i][1];
  }

  cout << sum << endl;

  return 0;
}
