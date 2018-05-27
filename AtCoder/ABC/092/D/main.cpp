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

  int a, b;
  cin >> a >> b;
  bool r = false;
  if(a > b){
    int tmp = a; a = b; b = tmp;
    r = true;
  }

  bool tab[100][100];
  for(int i = 0; i < 50; i++){
    fill(tab[i], tab[i] + 100, true);
  }
  for(int i = 50; i < 100; i++){
    fill(tab[i], tab[i] + 100, false);
  }

  int count = 0;
  int h = 0;
  while(count < a - 1){
    for(int j = 0;
        count < a - 1 && j < 100; j += 2){
      tab[h][j] = false;
      ++count;
    }
    h += 2;
  }
  h = 99;
  count = 0;
  while(count < b - 1){
    for(int j = 0;
        count < b - 1 && j < 100; j += 2){
      tab[h][j] = true;
      ++count;
    }
    h -= 2;
  }

  string ans;
  for(int i = 0; i < 100; i++){
    for(int j = 0; j < 100; j++){
      if(tab[i][j]) ans.append((!r) ? "#" : ".");
      else ans.append((!r) ? "." : "#");
    }
    ans.append("\n");
  }

  cout << to_string(100) + " " + to_string(100) << endl;
  cout << ans << endl;

  return 0;
}
