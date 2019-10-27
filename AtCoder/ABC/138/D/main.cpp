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
#define MAX_N 200000
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

vector< int > graph[MAX_N];
map< int, int > counter;

void dfs(int v, int p, int a, map< int, int >& c){
  c[v] = a + counter[v];
  for(int w: graph[v]){
    if(w != p) dfs(w, v, c[v], c);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, q;
  cin >> n >> q;
  int a[n - 1], b[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }
  int p[q], x[q];
  for(int i = 0; i < q; i++){
    cin >> p[i] >> x[i];
    --p[i];
  }

  for(int i = 0; i < n - 1; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }

  for(int i = 0; i < q; i++){
    counter[p[i]] += x[i];
  }

  map< int, int > ans;
  dfs(0, -1, 0, ans);

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(ans[i]) + " ";
  }

  cout << buf << endl;

  return 0;
}
