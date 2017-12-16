#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#include <cstring>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false

#define MAX_N 100010
#define B 900
#define MAX_M 5000
using namespace std;

int n, m;
int a[MAX_N];
int s[MAX_M], t[MAX_M], k[MAX_M];
vector< int > b[MAX_N / B];
int c[MAX_N];

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  cin >> n >> m;
  for(int i = 0; i < n; i++){
    cin >> a[i];
  }
  for(int i = 0; i < m; i++){
    cin >> s[i] >> t[i] >> k[i];
  }

  for(int i = 0; i < n; i++){
    c[i] = a[i];
    b[i / B].push_back(a[i]);
  }
  sort(c, c + n);
  for(int i = 0; i < n / B; i++){
    sort(b[i].begin(), b[i].end());
  }

  for(int i = 0; i < m; i++){
    int lb = -1, ub = n - 1;
    while(ub - lb > 1){
      int mid = (lb + ub) / 2;
      int x = c[mid];
      int count = 0;
      int l = s[i] - 1, r = t[i];
      while(l % B != 0 && l < r){
        if(a[l] <= x){
          ++count;
        }
        ++l;
      }
      while(r % B != 0 && l < r){
        if(a[r - 1] <= x){
          ++count;
        }
        --r;
      }
      while(l < r){
        count += distance(b[l / B].begin(), upper_bound(b[l / B].begin(), b[l / B].end(), x));
        l += B;
      }
      if(count >= k[i]){
        ub = mid;
      }
      else{
        lb = mid;
      }
    }
    cout << c[ub] << endl;
  }

  return 0;
}
