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
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int p[n + 1], b[n + 1];
  p[1] = a[0];
  for(int i = 2; i <= n; i++){
    p[i] = gcd(p[i - 1], a[i - 1]);
  }
  b[n - 1] = a[n - 1];
  for(int i = n - 2; i >= 0; i--){
    b[i] = gcd(b[i + 1], a[i]);
  }

  int ans = 1;
  for(int i = 0; i < n; i++){
    if(i == 0) ans = max(ans, b[1]);
    else if(i == n - 1) ans = max(ans, p[n - 1]);
    else ans = max(ans, gcd(p[i], b[i + 1]));
  }

  cout << ans << endl;

  return 0;
}
