#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
using namespace std;

int MOD = 1000000007;
int a[MAX_N];

map< int, int > dp[MAX_N + 1];

int solve(int i, int k){
  if(i == 0) return (k == 0) ? 1 : 0;
  if(dp[i].find(k) != dp[i].end())
    return dp[i][k];
  return dp[i][k] = 
    (solve(i - 1, k ^ a[i - 1]) + 
     solve(i - 1, k)) % MOD;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k;
  cin >> n >> k;
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  int ans = solve(n, k);

  cout << ans << endl;

  return 0;
}
