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

class Edge{
  public:
    int v, w, c;
    Edge(int v, int w, int c): v(v), w(w), c(c){}
};

vector< vector< Edge > > graph_a;
vector< vector< Edge > > graph_b;

void dijkstra(vector< vector< Edge > >& graph, int s, 
    vector< ll >& dist){
  fill(dist.begin(), dist.end(), INF_LONG);
  priority_queue< pli, vector< pli >, greater< pli >> pq;
  pq.push(make_pair(0, s));
  dist[s] = 0;
  while(!pq.empty()){
    pli p = pq.top(); pq.pop();
    int v = p.second;
    ll d = p.first;
    if(d > dist[v]) continue;
    for(Edge e: graph[v]){
      int w = e.w;
      if(d + e.c < dist[w]){
        dist[w] = d + e.c;
        pq.push(make_pair(d + e.c, w));
      }
    }
  }
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m, s, t;
  cin >> n >> m >> s >> t;
  --s; --t;
  int u[m], v[m], a[m], b[m];
  for(int i = 0; i < m; i++){
    cin >> u[i] >> v[i] >> a[i] >> b[i];
    --u[i]; --v[i];
  }

  graph_a.resize(n);
  graph_b.resize(n);
  for(int i = 0; i < m; i++){
    graph_a[u[i]].push_back(Edge(u[i], v[i], a[i]));
    graph_a[v[i]].push_back(Edge(v[i], u[i], a[i]));
    graph_b[u[i]].push_back(Edge(u[i], v[i], b[i]));
    graph_b[v[i]].push_back(Edge(v[i], u[i], b[i]));
  }

  vector< ll > dist_a(n), dist_b(n);
  dijkstra(graph_a, s, dist_a);
  dijkstra(graph_b, t, dist_b);

  ll ans[n + 1];
  ans[n] = INF_LONG;
  for(int i = n - 1; i >= 0; i--){
    ans[i] = min(ans[i + 1], dist_a[i] + dist_b[i]);
  }

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(1000000000000000l - ans[i]) + "\n";
  }

  cout << buf;

  return 0;
}
