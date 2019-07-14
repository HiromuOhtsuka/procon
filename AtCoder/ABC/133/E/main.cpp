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
#define MAX_N 100000
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

ll fac[MAX], finv[MAX], inv[MAX];
void init_comb(){
  fac[0] = fac[1] = 1;
  finv[0] = finv[1] = 1;
  inv[1] = 1;
  for(int i = 2; i < MAX; i++){
    fac[i] = fac[i - 1] * i % MOD;
    inv[i] = MOD - inv[MOD % i] * (MOD / i) % MOD;
    finv[i] = finv[i - 1] * inv[i] % MOD;
  }
}

ll comb(int n, int k){
  if(n < k) return 0;
  if(n < 0 || k < 0) return 0;
  return fac[n] * (finv[k] * finv[n - k] % MOD) % MOD;
}

vector< int > graph[MAX_N];

ll dfs(int v, int p, int k){
  int count = (p != -1) ? 
    graph[v].size() - 1 : graph[v].size();
  int kk = ((p != -1) ? k - 2: k - 1);
  ll sum = (comb(kk, count) * fac[count]) % MOD;
  for(int w :graph[v]){
    if(w != p) sum = (sum * dfs(w, v, k)) % MOD;
  }
  return sum;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k;
  cin >> n >> k;
  int a[n - 1], b[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }

  for(int i = 0; i < n - 1; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }

  init_comb();
  ll ans = dfs(0, -1, k);
  ans = (ans * k) % MOD;

  cout << ans << endl;

  return 0;
}
