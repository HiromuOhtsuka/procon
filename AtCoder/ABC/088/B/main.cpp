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
#define MAX_N 1000
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  vector< int > a;
  for(int i = 0; i < n; i++){
    int j;
    cin >> j;
    a.push_back(j);
  }

  sort(a.begin(), a.end(), greater< int >());
  int alice = 0, bob = 0;
  for(int i = n - 1; i >= 0; i--){
    if(i % 2 == 0) alice += a[i];
    else bob += a[i];
  }
  cout << (alice - bob) << endl;

  return 0;
}
