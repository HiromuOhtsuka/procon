#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

typedef long long ll;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  ll c[n - 1], s[n - 1], f[n - 1];
  for(int i = 0; i < n - 1; i++){
    cin >> c[i] >> s[i] >> f[i];
  }

  ll time[n];
  for(int i = 0; i < n - 1; i++){
    int t = 0;
    int k = i;
    for(int j = 0; j < n - i - 1; j++){
      if(t <= s[k]){
        t += (s[k] - t);
        t += c[k];
      }
      else if(t % f[k] == 0){
        t += c[k];
      }
      else{
        t += f[k] - t % f[k];
        t += c[k];
      }
      ++k;
    }
    time[i] = t;
  }
  time[n - 1] = 0;

  string ans;
  for(int i = 0; i < n; i++){
    ans += to_string(time[i]);
    ans += "\n";
  }

  cout << ans;

  return 0;
}
