#include <iostream>
#include <climits>
#include <cmath>
#include <algorithm>
#include <vector>
#include <map>
#include <set>
#include <queue>
#include <string>
#define INF_INT (INT_MAX / 2)
#define INF_LONG (LONG_MAX / 2)
//#define DEBUG true
#define DEBUG false
#define MAX_N 100
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n;
  cin >> n;
  int a[n], b[n], c[n], d[n];
  for(int i = 0; i < n; i++){
    cin >> a[i] >> b[i];
  }
  for(int i = 0; i < n; i++){
    cin >> c[i] >> d[i];
  }

  tuple< int, int, string > all[2 * MAX_N];
  int sp = 0;
  for(int i = 0; i < n; i++){
    all[sp++] = make_tuple(a[i], b[i], "red");
  }
  for(int i = 0; i < n; i++){
    all[sp++] = make_tuple(c[i], d[i], "blue");
  }
  sort(all, all + 2 * n);

  int count = 0;
  bool exist[2 * n];
  fill(exist, exist + 2 * n, true);
  for(int i = 0; i < 2 * n; i++){
    if(get< 2 >(all[i]) == "blue"){
      int mx = -1;
      for(int j = i - 1; j >= 0; j--){
        if(exist[j] && 
            get< 2 >(all[j]) == "red" &&
            get< 1 >(all[j]) < get< 1 >(all[i]) &&
            (mx == -1 || get< 1 >(all[mx]) < get< 1 >(all[j]))){
          mx = j;
        }
      }
      if(mx != -1){
        exist[mx] = false;
        ++count;
      }
    }
  }

  cout << count << endl;

  return 0;
}
