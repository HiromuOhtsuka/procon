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
#define MAX_N 2000
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

ll f(vector< string > s, int n, int m){
  ll sum1[n + 1][m + 1];
  for(int i = 0; i <= n; i++){
    fill(sum1[i], sum1[i] + m + 1, 0);
  }

  for(int i = 1; i <= n; i++){
    for(int j = 1; j <= m; j++){
      if(s[i - 1][j - 1] == '.')
        sum1[i][j] = sum1[i][j - 1] + 1;
      else sum1[i][j] = 0;
    }
  }

  ll sum[n + 1][m + 1];
  for(int i = 0; i <= n; i++){
    fill(sum[i], sum[i] + m + 1, 0);
  }
  for(int j = 1; j <= m; j++){
    for(int i = 1; i <= n; i++){
      if(i >= 2 && s[i - 2][j - 1] == '#') sum[i][j] = 0;
      else if(s[i - 1][j - 1] == '.')
        sum[i][j] = sum1[i - 1][j - 1] + sum[i - 1][j];
      else sum[i][j] = 0;
    }
  }

  ll result = 0;
  for(int i = 1; i <= n; i++){
    for(int j = 1; j <= m; j++){
      result += sum[i][j];
    }
  }

  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, m;
  cin >> n >> m;
  vector< string > s(n);
  for(int i = 0; i < n; i++) cin >> s[i];

  vector< string > s2(m), s3(n), s4(m);
  for(int i = 0; i < n; i++){
    s3[i].resize(m);
  }
  for(int i = 0; i < m; i++){
    s2[i].resize(n);
    s4[i].resize(n);
  }
  for(int j = m - 1; j >= 0; j--){
    for(int i = 0; i < n; i++){
      s2[-j + m - 1][i] = s[i][j];
    }
  }
  for(int i = n - 1; i >= 0; i--){
    for(int j = m - 1; j >= 0; j--){
      s3[-i + n - 1][-j + m - 1] = s[i][j];
    }
  }
  for(int j = 0; j < m; j++){
    for(int i = n - 1; i >= 0; i--){
      s4[j][-i + n - 1] = s[i][j];
    }
  }

  ll ans = f(s, n, m) + f(s2, m, n) + 
    f(s3, n, m) + f(s4, m, n);

  cout << ans << endl;

  return 0;
}
