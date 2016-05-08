#include <iostream>
#include <climits>
#include <algorithm>
#define MAX_N 50
using namespace std;

int N, a[MAX_N];

int main(){
  cin >> N;
  for(int i = 0; i < N; i++){
    cin >> a[i];
  }

  int ans = INT_MIN;
  for(int i = 0; i < N; i++){
    int max_ak = INT_MIN, ak_i;
    for(int j = 0; j < N; j++){
      if(i == j){
        continue;
      }
      int ak = 0;
      for(int k = min(i, j); k <= max(i, j); k++){
        if((k - min(i, j)) % 2 == 1){
          ak += a[k];
        }
      }
      if(ak > max_ak){
        max_ak = ak;
        ak_i = j;
      }
    }
    int tk = 0;
    for(int j = min(i, ak_i); j <= max(i, ak_i); j++){
      if((j - min(i, ak_i)) % 2 == 0){
        tk += a[j];
      }
    }
    ans = max(ans, tk);
  }

  cout << ans << endl;

  return 0;
}
