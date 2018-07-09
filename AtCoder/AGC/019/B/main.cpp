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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string a;
  cin >> a;

  int n = a.length();

  ll count[26];
  fill(count, count + 26, 0);
  for(int i = 0; i < n; i++){
    count[a[i] - 'a']++;
  }

  ll sub = 0;
  for(char ch = 'a'; ch <= 'z'; ch++){
    sub += count[ch - 'a'] * (count[ch - 'a'] - 1) / 2; 
  }

  ll sum = (ll)n * (n - 1) / 2 - sub + 1;

  cout << sum << endl;

  return 0;
}
