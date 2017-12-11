#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <map>
#include <queue>
#include <set>
#define INF (INT_MAX / 2)
#define MAX_N 300000
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, k;
  cin >> n >> k;
  int a[n];
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }

  int count[MAX_N + 1];
  fill(count, count + (MAX_N + 1), 0);
  for(int i = 0; i < n; i++){
    ++count[a[i]];
  }
  set< int > s;
  int m = 0;
  for(int i = 0; i <= MAX_N; i++){
    if(count[i] > 0){
      ++m;
      s.insert(i);
    }
  }
  if(m <= k){
    cout << 0 << endl;
    return 0;
  }

  int ss = (int)s.size();
  long long b[ss];
  int l = 0;
  for(auto itr = s.begin(); itr != s.end(); itr++){
    b[l++] = count[*itr];
  }
  sort(b, b + ss);
  long long sum = 0;
  for(int i = 0; i < m - k; i++){
    sum += b[i];
  }

  cout << sum << endl;

  return 0;
}
