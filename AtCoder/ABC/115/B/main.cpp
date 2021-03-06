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

const int MAX = 100001;
const int MOD = 1000000007;

typedef long long ll;
typedef pair< int, int > pii;
typedef pair< ll, ll > pll;
typedef pair< ll, int > pli;
typedef pair< int, ll > pil;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int p[n];
  for(int i = 0; i < n; i++) cin >> p[i];

  int j = 0;
  for(int i = 1; i < n; i++){
    if(p[j] < p[i]) j = i;
  }

  int sum = 0;
  for(int i = 0; i < n; i++){
    if(i == j) sum += p[i] / 2;
    else sum += p[i];
  }

  cout << sum << endl;

  return 0;
}
