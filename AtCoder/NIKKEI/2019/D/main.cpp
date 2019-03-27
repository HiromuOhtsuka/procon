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
#define DEBUG true
//#define DEBUG false
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

vector< int > graph[MAX_N];
vector< int > igraph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  int a[n - 1 + m], b[n - 1 + m];
  for(int i = 0; i < n - 1 + m; i++){
    cin >> a[i] >> b[i];
    --a[i]; --b[i];
  }

  int ind[n];
  fill(ind, ind + n, 0);
  for(int i = 0; i < n - 1 + m; i++){
    graph[a[i]].push_back(b[i]);
    ind[b[i]]++;
    igraph[b[i]].push_back(a[i]);
  }

  int root;
  for(int v = 0; v < n; v++){
    if(ind[v] == 0){
      root = v;
      break;
    }
  }

  int order[n], iorder[n];
  int i = 0;
  queue< int > que;
  que.push(root);
  while(!que.empty()){
    int v = que.front(); que.pop();
    order[i] = v; iorder[v] = i;
    ++i;
    for(int w: graph[v]){
      ind[w]--;
      if(ind[w] == 0) que.push(w);
    }
  }

  int parent[n];
  parent[root] = 0;
  for(int v = 0; v < n; v++){
    if(v == root) continue;
    int p = -1;
    for(int w: igraph[v]){
      p = max(p, iorder[w]);
    }
    parent[v] = order[p] + 1;
  }

  string buf;
  for(int v = 0; v < n; v++){
    buf += to_string(parent[v]) + "\n";
  }

  cout << buf;

  return 0;
}
