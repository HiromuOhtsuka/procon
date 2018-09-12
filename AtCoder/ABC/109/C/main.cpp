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

  int n, sx;
  cin >> n >> sx;
  int x[n];
  for(int i = 0; i < n; i++) cin >> x[i];

  int y[n + 1];
  for(int i = 0; i < n; i++){
    y[i] = x[i];
  }
  y[n] = sx;

  sort(y, y + n + 1);

  int ans = y[1] - y[0];
  for(int i = 1; i + 1 < n + 1; i++){
    ans = gcd(ans, y[i + 1] - y[i]);
  }

  cout << ans << endl;

  return 0;
}
