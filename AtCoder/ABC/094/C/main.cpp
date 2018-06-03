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
#define MAX_N 200000
using namespace std;

typedef pair< int, int > pii;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  pii c[MAX_N];
  for(int i = 0; i < n; i++){
    c[i] = make_pair(a[i], i);
  }
  sort(c, c + n);
  int d[n];
  for(int i = 0; i < n; i++){
    d[c[i].second] = i;
  }

  int b[n];
  for(int i = 0; i < n; i++){
    if(d[i] < (n / 2)) b[i] = c[n / 2].first;
    else b[i] = c[n / 2 - 1].first;
  }

  string buf;
  for(int i = 0; i < n; i++){
    buf += to_string(b[i]) + "\n";
  }

  cout << buf;

  return 0;
}
