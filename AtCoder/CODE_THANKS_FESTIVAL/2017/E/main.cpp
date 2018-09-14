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

int pow(int x, int y){
  int result = 1;
  for(int i = 0; i < y; i++){
    result *= x;
  }
  return result;
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;

  int w[n];
  for(int i = 0; i < n; i += 5){
    int j = min(i + 5, n);
    string s = "?";
    int c = 0;
    for(int k = 0; k < n; k++){
      if(k < i || k >= j) s += " 0";
      else{
        int t = pow(5, (k - i));
        c += t;
        s += " " + to_string(t);
      }
    }
    cout << s << endl << flush;
    int sum;
    cin >> sum;
    sum -= 8 * c;
    for(int k = i; k < j; k++){
      w[k] = (sum % 5) + 8;
      sum /= 5;
    }
  }

  string buf = "!";
  for(int i = 0; i < n; i++){
    buf += " " + to_string(w[i] % 2);
  }

  cout << buf << endl;

  return 0;
}
