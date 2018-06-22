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
  int a[n];
  for(int i = 0; i < n; i++) cin >> a[i];

  int sum = 0;
  for(int i = 0; i < n; i++){
    int j = 0;
    int m = a[i];
    while(m % 2 == 0){
      m /= 2;
      ++j;
    }
    sum += j;
  }

  cout << sum << endl;

  return 0;
}
