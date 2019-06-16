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
  vector< string > s(h);
  for(int i = 0; i < h; i++) cin >> s[i];

  vector< vector< int > > x(h), y(w);
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(s[i][j] == '#'){
        x[i].push_back(j + 1);
        y[j].push_back(i + 1);
      }
    }
  }
  for(int i = 0; i < h; i++){
    x[i].push_back(0);
    x[i].push_back(w + 1);
    sort(x[i].begin(), x[i].end());
  }
  for(int i = 0; i < w; i++){
    y[i].push_back(0);
    y[i].push_back(h + 1);
    sort(y[i].begin(), y[i].end());
  }

  int ans = 0;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(s[i][j] == '.'){
        auto lbx = lower_bound(x[i].begin(), x[i].end(), j + 1);
        auto lby = lower_bound(y[j].begin(), y[j].end(), i + 1);
        ans = max(ans, *lbx - *(lbx - 1) + *lby - *(lby - 1) - 3);
      }
    }
  }

  cout << ans << endl;

  return 0;
}
