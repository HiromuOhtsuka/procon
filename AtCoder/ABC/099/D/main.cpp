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
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int n, c;
  cin >> n >> c;
  int d[c][c], color[n][n];
  for(int i = 0; i < c; i++){
    for(int j = 0; j < c; j++){
      cin >> d[i][j];
    }
  }
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      cin >> color[i][j];
    }
  }

  int cost[3][c];
  for(int i = 0; i < 3; i++){
    fill(cost[i], cost[i] + c, 0);
  }
  for(int i = 0; i < n; i++){
    for(int j = 0; j < n; j++){
      for(int k = 0; k < c; k++){
        cost[(i + j) % 3][k] += d[color[i][j] - 1][k];
      }
    }
  }

  int ans = INF_INT;
  for(int c1 = 0; c1 < c; c1++){
    for(int c2 = 0; c2 < c; c2++){
      if(c1 == c2) continue;
      for(int c3 = 0; c3 < c; c3++){
        if(c2 == c3 || c1 == c3) continue;
        ans = min(ans, cost[0][c1] + cost[1][c2] + cost[2][c3]);
      }
    }
  }

  cout << ans << endl;

  return 0;
}
