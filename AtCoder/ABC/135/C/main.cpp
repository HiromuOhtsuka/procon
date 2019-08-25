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

  int n;
  cin >> n;
  int a[n + 1], b[n];
  for (int i = 0; i < n + 1; i++)
  {
    cin >> a[i];
  }
  for (int i = 0; i < n; i++)
  {
    cin >> b[i];
  }

  ll sum = 0;
  for (int i = 0; i < n; i++)
  {
    int d = min(b[i], a[i]);
    b[i] -= d;
    a[i] -= d;
    sum += d;
    d = min(b[i], a[i + 1]);
    b[i] -= d;
    a[i + 1] -= d;
    sum += d;
  }

  cout << sum << endl;

  return 0;
}
