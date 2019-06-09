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

  int n, k;
  cin >> n >> k;
  int v[n];
  for(int i = 0; i < n; i++) cin >> v[i];

  int ans = -INF_INT;
  for(int l = 0; l <= min(n, k); l++){
    for(int r = 0; r <= min(n, k) && l + r <= min(n, k); r++){
      vector< int > tmp(l + r);
      int sum = 0;
      for(int i = 0; i < l; i++){
        sum += v[i];
        tmp.push_back(v[i]);
      }
      for(int i = n - 1; i >= (n - r); i--){
        sum += v[i];
        tmp.push_back(v[i]);
      }
      sort(tmp.begin(), tmp.end());
      for(int i = 0; i < k - (l + r) && i < (l + r); i++){
        if(tmp[i] < 0) sum -= tmp[i];
      }
      ans = max(ans, sum);
    }
  }

  cout << ans << endl;

  return 0;
}
