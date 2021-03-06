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

  int d;
  cin >> d;

  if(d == 25){
    cout << "Christmas" << endl;
  }
  else if(d == 24){
    cout << "Christmas Eve" << endl;
  }
  else if(d == 23){
    cout << "Christmas Eve Eve" << endl;
  }
  else if(d == 22){
    cout << "Christmas Eve Eve Eve" << endl;
  }

  return 0;
}
