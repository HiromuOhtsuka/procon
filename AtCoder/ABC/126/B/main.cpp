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

int ceil(int x, int y){
  return (x % y == 0) ? x / y : x / y + 1;
}

int gcd(int x, int y){
  return y ? gcd(y, x % y) : x;
}

int lcm(int x, int y){
  return x / gcd(x, y) * y;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  string s;
  cin >> s;

  int a = 10 * (s[0] - '0') + (s[1] - '0');
  int b = 10 * (s[2] - '0') + (s[3] - '0');

  bool yymm = false, mmyy = false;
  if(b >= 1 && b <= 12) yymm = true;
  if(a >= 1 && a <= 12) mmyy = true;

  if(yymm & mmyy) cout << "AMBIGUOUS" << endl;
  else if(yymm) cout << "YYMM" << endl;
  else if(mmyy) cout << "MMYY" << endl;
  else cout << "NA" << endl;

  return 0;
}
