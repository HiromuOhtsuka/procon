#include <iostream>
#include <algorithm>
#include <vector>
#define MAX_N 2000
#define MAX_K MAX_N
#define MAX_G 10
using namespace std;

int N, K, c[MAX_N], dp[MAX_G][MAX_N], s[MAX_G][MAX_N];
vector< int > g[MAX_N];

int main(){
  cin >> N >> K;
  for(int i = 0; i < N; i++){
    int n;
    cin >> c[i] >> n;
    g[--n].push_back(c[i]);
  }

  for(int i = 0; i < MAX_G; i++){
    if(g[i].empty()){
      continue;
    }
    sort(g[i].begin(), g[i].end());
    s[i][0] = g[i][0];
    for(int j = g[i].size() - 1; j > 0; j--){
      s[i][j] += s[i][j - 1] + g[i][j];
    }
  }


  return 0;
}
