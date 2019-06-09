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
#define MAX_N 10000
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

int n;
vector< int > graph[MAX_N];
priority_queue< int, vector< int >, greater< int > > pq;

void dfs(int v, bool visited[], int d[]){
  if(visited[v]) return;
  visited[v] = true;
  for(int w: graph[v]){
    dfs(w, visited, d);
  }
  d[v] = pq.top();
  pq.pop();
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n;
  int a[n - 1], b[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }
  int c[n];
  for(int i = 0; i < n; i++) cin >> c[i];

  for(int i = 0; i < n - 1; i++){
    graph[a[i]].push_back(b[i]);
    graph[b[i]].push_back(a[i]);
  }
  for(int i = 0; i < n; i++){
    pq.push(c[i]);
  }

  int d[n];
  bool visited[n];
  fill(visited, visited + n, false);

  dfs(0, visited, d);

  int m = 0;
  int mx = 0;
  for(int i = 0; i < n; i++){
    m += c[i];
    mx = max(mx, c[i]);
  }
  m -= mx;

  string buf;
  buf += to_string(m) + "\n";
  for(int i = 0; i < n; i++){
    buf += to_string(d[i]) + " ";
  }

  cout << buf << endl;

  return 0;
}
