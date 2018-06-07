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
#define MAX_H 50
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int h, w;
  cin >> h >> w;
  string s[MAX_H];
  for(int i = 0; i < h; i++) cin >> s[i];

  int dx[4] = {0, 1, 0, -1};
  int dy[4] = {-1, 0, 1, 0};
  for(int i = 0; i < h; i++){
    for(int j = 0; j < w; j++){
      if(s[i][j] == '.') continue;
      bool exist = false;
      for(int k = 0; k < 4; k++){
        int ni = i + dy[k];
        int nj = j + dx[k];
        if(!(0 <= ni && ni < h) && (0 <= nj && nj < w))
          continue;
        if(s[ni][nj] == '#'){
          exist = true;
          break;
        }
      }
      if(!exist){
        cout << "No" << endl;
        return 0;
      }
    }
  }

  cout << "Yes" << endl;

  return 0;
}
