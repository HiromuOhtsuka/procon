#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  int n = s.length();

  int m = INF;
  for(int i = 0; i + 1 < n; i++){
    if(s[i] != s[i + 1]){
      m = min(m, max(i + 1, n - (i + 1)));
    }
  }

  if(m == INF) cout << n << endl;
  else cout << m << endl;

  return 0;
}
