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
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  ll ans[n];
  fill(ans, ans + n, 0);
  for(int k = 0; k < n; k++){
    for(int s = 0; s + k < n; s++){
      ll sum = 0;
      for(int t = s; t <= s + k; t++){
        sum += a[t];
      }
      ans[k] = max(ans[k], sum);
    }
  }

  string buf;
  for(int k = 0; k < n; k++){
    buf += to_string(ans[k]) + "\n";
  }

  cout << buf;

  return 0;
}
