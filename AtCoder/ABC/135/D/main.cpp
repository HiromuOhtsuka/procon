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
using namespace std;

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair<int, int> pii;
typedef pair<ll, ll> pll;
typedef pair<ll, int> pli;
typedef pair<int, ll> pil;

int ceil(int x, int y)
{
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y)
{
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y)
{
  return x / gcd(x, y) * y;
}

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  int n = s.length();

  ll pow[n + 1];
  pow[0] = 1;
  for (int i = 1; i <= n; i++)
  {
    pow[i] = (pow[i - 1] * 10) % 13;
  }

  reverse(s.begin(), s.end());

  ll dp[n + 1][13];

  fill(dp[0], dp[0] + 13, 0);
  dp[0][0] = 1;

  for (int i = 1; i <= n; i++)
  {
    for (int j = 0; j < 13; j++)
    {
      dp[i][j] = 0;
      if (s[i - 1] != '?')
      {
        ll k = s[i - 1] - '0';
        int r = (k * pow[i - 1]) % 13;
        dp[i][j] = dp[i - 1][(j - r + 13) % 13];
      }
      else
      {
        for (ll k = 0; k < 10; k++)
        {
          int r = (k * pow[i - 1]) % 13;
          dp[i][j] = (dp[i][j] + dp[i - 1][(j - r + 13) % 13]) % MOD;
        }
      }
    }
  }

  cout << dp[n][5] << endl;

  return 0;
}
