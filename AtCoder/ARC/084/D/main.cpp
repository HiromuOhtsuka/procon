#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <queue>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
using namespace std;

class edge{
  public:
    int u, v, w;
    edge(){}
    edge(int u, int v, int w):
      u(u), v(v), w(w){}
};

vector< edge > graph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int k;
  cin >> k;

  for(int v = 0; v < k; v++){
    graph[v].push_back(edge(v, (v + 1) % k, 1));
    graph[v].push_back(edge(v, (10 * v) % k, 0));
  }

  int dist[k];
  fill(dist, dist + k, INF);
  priority_queue< pair< int, int > > pq;
  pq.push(pair< int, int >(0, 1));
  dist[1] = 0;
  while(not pq.empty()){
    pair< int, int > p = pq.top();  pq.pop();
    int u = p.second, d = -p.first;
    if(d > dist[u]) continue;
    for(edge e: graph[u]){
      if(d + e.w < dist[e.v]){
        dist[e.v] = d + e.w;
        pq.push(pair< int, int >(-(d + e.w), e.v));
      }
    }
  }

  cout << (dist[0] + 1) << endl;

  return 0;
}
