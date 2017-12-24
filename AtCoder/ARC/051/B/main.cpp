#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_K 40
using namespace std;

typedef long long ll;

int counter = 0;
int gcd(int a, int b) {
  if (b == 0) return a;
  counter++;
  return gcd(b, a%b);
}

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int k;
  cin >> k;

  ll f[MAX_K + 1];
  f[0] = f[1] = 1;
  for(int i = 2; i <= MAX_K; i++){
    f[i] = f[i - 2] + f[i - 1];
  }

  if(DEBUG){
    gcd(f[k - 1], f[k]);
    if(k == counter) cout << "valid" << endl;
    else cout << "invalid" << endl;
  }

  cout << to_string(f[k - 1]) + " " + to_string(f[k]) << endl;

  return 0;
}
