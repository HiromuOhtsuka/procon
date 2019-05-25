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

int n, m;
vector< int > graph[MAX_N];

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

void dfs(int v, bool visited[]){
  if(visited[v]) return;
  visited[v] = true;
  for(int w: graph[v]){
    dfs(w, visited);
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < m; i++){
    int x, y, z;
    cin >> x >> y >> z;
    --x; --y;
    graph[x].push_back(y);
    graph[y].push_back(x);
  }

  int count = 0;
  bool visited[n];
  fill(visited, visited + n, false);
  for(int v = 0; v < n; v++){
    if(!visited[v]){
      dfs(v, visited);
      ++count;
    }
  }

  cout << count << endl;

  return 0;
}
