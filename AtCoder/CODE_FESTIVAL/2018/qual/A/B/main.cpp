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

  int n, m, a, b;
  cin >> n >> m >> a >> b;
  int l[m], r[m];
  for(int i = 0; i < m; i++){
    cin >> l[i] >> r[i];
  }

  int v[n + 1];
  fill(v, v + n + 1, max(a, b));
  for(int i = 0; i < m; i++){
    for(int j = l[i]; j <= r[i]; j++){
      v[j] = a;
    }
  }

  int sum = 0;
  for(int i = 1; i <= n; i++){
    sum += v[i];
  }

  cout << sum << endl;

  return 0;
}
