#include <iostream>
#include <vector>
#define MAX_N 100000
#define MOD (1000000007)
using namespace std;

int N;
vector< int > G[MAX_N];

long long dp[MAX_N], dp2[MAX_N];

void dfs(int p, int v){
  vector< int > child;

  for(int i = 0; i < G[v].size(); i++){
    if(G[v][i] != p){
      child.push_back(G[v][i]);
    }
  }

  for(int i = 0; i < child.size(); i++){
    dfs(v, child[i]);
  }

  dp2[v] = dp[v] = 1;
  for(int i = 0; i < child.size(); i++){
    dp2[v] = (dp2[v] * dp[child[i]]) % MOD;
    dp[v] = (dp[v] * dp2[child[i]]) % MOD;
  }
  dp[v] = (dp[v] + dp2[v]) % MOD;
}

int main(){
  cin >> N;
  for(int i = 1; i < N; i++){
    int a, b;
    cin >> a >> b;
    --a, --b;
    G[a].push_back(b);  G[b].push_back(a);
  }

  dfs(-1, 0);

  cout << dp[0] << endl;

  return 0;
}
