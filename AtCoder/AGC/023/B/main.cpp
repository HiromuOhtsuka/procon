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
#define MAX_N 300
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  string s[MAX_N];
  for(int i = 0; i < n; i++) cin >> s[i];

  int count = 0;
  for(int b = 0; b < n; b++){
    char m[n][n];
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        m[i][j] = s[i][(j + b) % n];
      }
    }
    bool good = true;
    for(int i = 0; i < n; i++){
      for(int j = 0; j < n; j++){
        if(m[i][j] != m[j][i]){
          good = false;
          break;
        }
      }
    }
    if(good) ++count;
  }

  int ans = count * n;

  cout << ans << endl;

  return 0;
}
