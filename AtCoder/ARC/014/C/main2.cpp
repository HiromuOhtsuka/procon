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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  string s;
  cin >> n;
  cin >> s;

  int r = 0, g = 0, b = 0;
  for(int i = 0; i < s.length(); i++){
    switch(s[i]){
      case 'R': ++r; break;
      case 'G': ++g; break;
      case 'B': ++b; break;
    }
  }

  int ans = (r % 2) + (g % 2) + (b % 2);
  cout << ans << endl;

  return 0;
}

