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

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  while(true){
    int n, m, t, p;
    cin >> n >> m >> t >> p;
    if(n == 0) break;
    int d[t], c[t];
    for(int i = 0; i < t; i++){
      cin >> d[i] >> c[i];
    }
    int x[p], y[p];
    for(int i = 0; i < p; i++){
      cin >> x[i] >> y[i];
    }

    int tab[1000][1000];
    for(int i = 0; i < 1000; i++){
      fill(tab[i], tab[i] + 1000, 0);
    }

    for(int i = 0; i < m; i++){
      fill(tab[i], tab[i] + n, 1);
    }

    int x0 = 0, y0 = 0;
    for(int i = 0; i < t; i++){
      if(d[i] == 1){
        for(int j = y0; j < y0 + m; j++){
          for(int k = x0; k < x0 + c[i]; k++){
            //tab[j][k + c[i]] += tab[j][k];
            tab[j][2 * c[i] - (k - x0) + x0 - 1] += tab[j][k];
            tab[j][k] = 0;
          }
        }
        x0 += c[i];
      }
      else{
        for(int j = y0; j < y0 + c[i]; j++){
          for(int k = x0; k < x0 + n; k++){
            //tab[j + c[i]][k] += tab[j][k];
            tab[2 * c[i] - (j - y0) + y0 - 1][k] += tab[j][k];
            tab[j][k] = 0;
          }
        }
        y0 += c[i];
      }
    }

    for(int i = 0; i < p; i++){
      cout << tab[y0 + y[i]][x0 + x[i]] << endl;
    }
  }

  return 0;
}
