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

  int n;
  cin >> n;
  int v[n];
  for(int i = 0; i < n; i++) cin >> v[i];
  int c[n];
  for(int i = 0; i < n; i++) cin >> c[i];

  int ans = 0;
  for(int s = 0; s < (1 << n); s++){
    int x = 0, y = 0;
    for(int i = 0; i < n; i++){
      if((s & (1 << i)) != 0){
        x += v[i];  y += c[i];
      }
    }
    ans = max(ans, x - y);
  }

  cout << ans << endl;

  return 0;
}
