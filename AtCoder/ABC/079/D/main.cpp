#include <iostream>
#include <queue>
#include <vector>
#include <climits>
#include <algorithm>
#define MAX_H 200
#define MAX_W 200
#define INF (INT_MAX / 2)
using namespace std;

typedef pair< int, int > P;

class edge{
  public:
    int u, v;
    int w;
    edge(int u, int v, int w): u(u), v(v), w(w) {}
};

vector< int > dijkstra(vector< edge > graph[], int n, int s){
  vector< int > dist(n);
  priority_queue< P, vector< P >, greater< P > > pq;

  fill(dist.begin(), dist.end(), INF);
  dist[s] = 0;
  pq.push(P(0, s));

  while(!pq.empty()){
    P p = pq.top(); pq.pop();
    int v = p.second;
    if(dist[v] < p.first) continue;
    for(int i = 0; i < graph[v].size(); i++){
      edge e = graph[v][i];
      if(dist[e.v] > dist[v] + e.w){
        dist[e.v] = dist[v] + e.w;
        pq.push(P(dist[e.v], e.v));
      }
    }
  }

  return dist;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int h, w;
  int c[10][10];
  int a[MAX_H][MAX_W];
  cin >> h >> w;
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      cin >> c[i][j];
    }
  }
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      cin >> a[i][j];
    }
  }

  vector< edge > graph[10];
  for(int i = 0; i < 10; i++){
    for(int j = 0; j < 10; j++){
      graph[i].push_back(edge(i, j, c[j][i]));
    }
  }
  vector< int > cost = dijkstra(graph, 10, 1);
  int sum = 0;
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(a[i][j] != -1){
        sum += cost[a[i][j]];
      }
    }
  }

  cout << sum << endl;

  return 0;
}
