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

void swap(int *a, int *b)
{
  int tmp = *a;
  *a = *b;
  *b = tmp;
}

int main()
{
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int p[n];
  for (int i = 0; i < n; i++)
  {
    cin >> p[i];
  }

  bool ans = false;
  for (int i = 0; i < n; i++)
  {
    for (int j = i; j < n; j++)
    {
      swap(&p[i], &p[j]);
      bool sorted = true;
      for (int k = 0; k + 1 < n; k++)
      {
        if (p[k] > p[k + 1])
        {
          sorted = false;
          break;
        }
      }
      if (sorted)
      {
        ans = true;
        break;
      }
      swap(&p[i], &p[j]);
    }
  }

  if (ans)
  {
    cout << "YES" << endl;
  }
  else
  {
    cout << "NO" << endl;
  }

  return 0;
}
