#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#include <string>
#include <set>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100000
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int q;
  cin >> q;
  int l[q], r[q];
  for(int i = 0; i < q; i++){
    cin >> l[i] >> r[i];
  }

  bool tab[MAX_N + 1];
  fill(tab, tab + (MAX_N + 1), true);
  tab[0] = tab[1] = false;
  for(int i = 2; i <= MAX_N; i++){
    if(tab[i]){
      for(int j = 2; i * j <= MAX_N; j++){
        tab[i * j] = false;
      }
    }
  }
  set< int > primes;
  for(int i = 2; i <= MAX_N; i++){
    if(tab[i]) primes.insert(i);
  }

  int sum[MAX_N + 1];
  fill(sum, sum + (MAX_N + 1), 0);
  for(int i = 0; i <= MAX_N; i++){
    if(i % 2 != 1) continue;
    if(primes.find(i) != primes.end() && 
      primes.find((i + 1) / 2) != primes.end()){
      sum[i] = 1;
    }
  }

  for(int i = 0; i <= MAX_N; i++){
    sum[i] += sum[i - 1];
  }

  string ans;
  for(int i = 0; i < q; i++){
    ans += to_string(sum[r[i]] - sum[l[i] - 1]);
    ans += "\n";
  }

  cout << ans;

  return 0;
}
