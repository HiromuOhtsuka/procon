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
#define MAX_N 500
#define MAX_M 500
using namespace std;

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

int n, m;
int a[MAX_N][MAX_M];

int dp[MAX_N + 1][1024];
int c[MAX_N + 1][1024];

int search(int i, int k){
  if(i == n) return dp[i][k] = (k > 0);
  if(dp[i][k] >= 0) return dp[i][k];
  int result = 0;
  for(int j = 0; j < m; j++){
    int tmp = search(i + 1, k ^ a[i][j]);
    if(tmp > 0) c[i][k] = j;
    result |= tmp;
    if(result > 0) break;
  }
  return dp[i][k] = result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < n; i++){
    for(int j = 0; j < m; j++){
      cin >> a[i][j];
    }
  }

  for(int i = 0; i <= n; i++){
    fill(dp[i], dp[i] + 1024, -1);
    fill(c[i], c[i] + 1024, -1);
  }

  int found = search(0, 0);
  if(found == 0){
    cout << "NIE" << endl;
    return 0;
  }

  string buf = "TAK\n";
  int k = 0;
  for(int i = 0; i < n; i++){
    buf += to_string(c[i][k] + 1) + " ";
    k ^= a[i][c[i][k]];
  }

  cout << buf << endl;

  return 0;
}
