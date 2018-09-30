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

  int n, m, x, y;
  cin >> n >> m >> x >> y;
  int xx[n], yy[m];
  for(int i = 0; i < n; i++) cin >> xx[i];
  for(int i = 0; i < m; i++) cin >> yy[i];

  int mx = x;
  for(int i = 0; i < n; i++){
    mx = max(mx, xx[i]);
  }
  int mi = y;
  for(int i = 0; i < m; i++){
    mi = min(mi, yy[i]);
  }

  if(mi - mx >= 1) cout << "No War" << endl;
  else cout << "War" << endl;

  return 0;
}
