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

  string s, t;
  cin >> s >> t;

  bool ans = false;
  int n = s.length();
  for(int i = 0; i < n; i++){
    char last = s[n - 1];
    s.pop_back();
    s.insert(0, 1, last);
    if(s == t){
      ans = true;
      break;
    }
  }

  if(ans) cout << "Yes" << endl;
  else cout << "No" << endl;

  return 0;
}
