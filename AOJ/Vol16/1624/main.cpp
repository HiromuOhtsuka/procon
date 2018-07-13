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

  while(true){
    int n;
    cin >> n;
    if(n == 0) break;
    int a[n];
    for(int i = 0; i < n; i++) cin >> a[i];

    int sum = 0;
    for(int i = 0; i < n; i++){
      sum += a[i];
    }

    int count = 0;
    for(int i = 0; i < n; i++){
      if(a[i] * n <= sum) ++count;
    }

    cout << count << endl;
  }
  return 0;
}
