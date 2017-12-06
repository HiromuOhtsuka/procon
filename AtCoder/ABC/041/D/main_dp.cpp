#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_N 16
using namespace std;

vector< int > graph[MAX_N];

int main(){
  int n, m;
  cin >> n >> m;
  for(int i = 0; i < m; i++){
    int x, y;
    cin >> x >> y;
    graph[x - 1].push_back(y - 1);
  }

  long long dp[1 << n];
  fill(dp, dp + (1 << n), 0);
  dp[0] = 1;
  for(int s = 1; s < (1 << n); s++){
    for(int v = 0; v < n; v++){
      if((s & (1 << v)) != 0){
        bool exist = false;
        for(int j = 0; j < graph[v].size(); j++){
          int w = graph[v][j];
          if((s & (1 << w)) != 0){
            exist = true;
            break;
          }
        }
        if(!exist){
          dp[s] += dp[s & ~(1 << v)];
        }
      }
    }
  }

  cout << dp[(1 << n) - 1] << endl;

  return 0;
}
