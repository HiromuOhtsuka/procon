#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  long long a, b, k, l;
  cin >> a >> b >> k >> l;

  long long c0 = (k / l) * b + (k - (k / l) * l) * a;
  long long c1 = ((k / l) + 1) * b;

  cout << min(c0, c1) << endl;

  return 0;
}
