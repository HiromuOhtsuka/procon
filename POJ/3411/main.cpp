#include <iostream>
#include <algorithm>
#include <vector>
#include <climits>
#include <queue>
#define INF (INT_MAX / 2)
#define MAX_N 10
using namespace std;

class tii{
  public:
    int first, second, third;
    tii(int f, int s, int t): first(f), second(s), third(t){}
    bool operator>(const tii& t) const{
      if(first == t.first){
        if(second == t.second){
          return third > t.third;
        }
        return second > t.second;
      }
      return first > t.first;
    }
};

class edge{
  public:
    int u, v;
    int c;
    int p, r;
    edge(int u, int v, int c, int p, int r):
      u(u), v(v), c(c), p(p), r(r){}
};

vector< edge > graph[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  for(int i = 0; i < m; i++){
    int a, b, c, p, r;
    cin >> a >> b >> c >> p >> r;
    graph[a - 1].push_back(
        edge(a - 1, b - 1, c - 1, p, r));
  }

  int dp[1 << n][n];
  for(int s = 0; s < (1 << n); s++){
    fill(dp[s], dp[s] + n, INF);
  }
  priority_queue< tii, vector< tii >, greater< tii > > pq;
  pq.push(tii(1, 0, 0));
  dp[1][0] = 0;
  while(!pq.empty()){
    tii e = pq.top(); pq.pop();
    int s = e.first;
    int d = e.second;
    int v = e.third;
    for(int i = 0; i < graph[v].size(); i++){
      edge& e = graph[v][i];
      int w = e.v;
      int ns = s | (1 << w);
      int cost;
      if((s & (1 << e.c)) != 0){
        cost = d + e.p;
      }
      else{
        cost = d + e.r;
      }
      if(dp[ns][w] > cost){
        dp[ns][w] = cost;
        pq.push(tii(ns, cost, w));
      }
    }
  }

  int ans = INF;
  for(int s = 0; s < (1 << n); s++){
    ans = min(ans, dp[s][n - 1]);
  }

  if(ans != INF){
    cout << ans << endl;
  }
  else{
    cout << "impossible" << endl;
  }

  return 0;
}
