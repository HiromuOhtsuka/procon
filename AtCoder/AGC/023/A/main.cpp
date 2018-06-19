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
using namespace std;

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  ll a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  ll s[n + 1];
  s[0] = 0;
  for(int i = 1; i <= n; i++){
    s[i] = s[i - 1] + a[i - 1];
  }

  map< ll, ll > counts;
  for(int i = 0; i <= n; i++){
    if(counts.find(s[i]) != counts.end())
      counts[s[i]] = counts[s[i]] + 1;
    else counts[s[i]] = 1;
  }

  ll sum = 0;
  for(auto& c: counts){
    sum += c.second * (c.second - 1) / 2;
  }

  cout << sum << endl;

  return 0;
}
