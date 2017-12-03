#include <iostream>
#define MAX 100000
#include <vector>
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, c;
  cin >> n >> c;
  int s[n];
  int t[n];
  int ch[n];
  for(int i = 0; i < n; i++){
    cin >> s[i] >> t[i] >> ch[i];
  }

  int table0[c][MAX + 1];
  for(int i = 0; i < c; i++){
    fill(table0[i], table0[i] + (MAX + 1), 0);
  }
  for(int i = 0; i < n; i++){
    ++table0[ch[i] - 1][s[i]];
    --table0[ch[i] - 1][t[i]];
  }
  vector< int > s0, t0;
  for(int i = 0; i < c; i++){
    int u = 0;
    for(int j = 0; j <= MAX; j++){
      int v = u + table0[i][j];
      if(u == 0 && v == 1){
        s0.push_back(j);
      }
      else if(u == 1 && v == 0){
        t0.push_back(j);
      }
      u = v;
    }
  }

  int table[MAX * 2 + 1];
  fill(table, table + (MAX * 2 + 1), 0);
  for(int i = 0; i < s0.size(); i++){
    ++table[2 * s0[i] - 1];
    --table[2 * t0[i]];
  }

  int ans = 1;
  int sum = 0;
  for(int i = 0; i <= 2 * MAX; i++){
    sum += table[i];
    ans = max(ans, sum);
  }

  cout << ans << endl;

  return 0;
}
