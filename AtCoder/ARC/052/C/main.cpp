#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#include <map>
#include <queue>
#define INF_LONG_LONG (LONG_LONG_MAX / 2)
#define INF_INT (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 10000
using namespace std;

typedef tuple< int, long long, int > tii;

class edge{
  public:
    int u, v, c;
    edge(int u, int v, int c): u(u), v(v), c(c){}
    edge(){}
};

vector< edge > graph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  for(int i = 0; i < m; i++){
    int c, a, b;
    cin >> c >> a >> b;
    graph[a].push_back(edge(a, b, c));
    graph[b].push_back(edge(b, a, c));
  }

  long long dist[n];
  fill(dist, dist + n, INF_LONG_LONG);
  priority_queue< tii, vector< tii >, greater< tii > > pq;
  pq.push(tii(0, 0, 0));
  dist[0] = 0;
  while(not pq.empty()){
    tii tmp = pq.top(); pq.pop();
    int c = get< 0 >(tmp);
    long long d = get< 1 >(tmp);
    int v = get< 2 >(tmp);
    dist[v] = min(dist[v], d);
    for(edge e: graph[v]){
      int w = e.v;
      if(e.c == 0){
        if(dist[w] > d + 1){
          pq.push(tii(c, d + 1, w));
        }
      }
      else{
        if(dist[w] > d + (c + 1)){
          pq.push(tii(c + 1, d + (c + 1), w));
        }
      }
    }
  }

  string ans;
  for(long long d: dist){
    ans += to_string(d) + "\n";
  }

  cout << ans;

  return 0;
}
