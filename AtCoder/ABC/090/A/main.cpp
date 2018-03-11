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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s[3];
  for(int i = 0; i < 3; i++){
    cin >> s[i];
  }

  cout << s[0][0];
  cout << s[1][1];
  cout << s[2][2] << endl;

  return 0;
}
