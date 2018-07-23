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

typedef long long ll;
typedef pair< int, int > pii;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int b[n];
  for(int i = 0; i < n; i++){
    b[i] = a[i] - (i + 1);
  }

  sort(b, b + n);
  int c = b[n / 2];
  ll sum = 0;
  for(int i = 0; i < n; i++){
    sum += abs(b[i] - c);
  }

  cout << sum << endl;

  return 0;
}
