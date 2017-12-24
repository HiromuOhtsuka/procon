#include <iostream>
#include <vector>
#include <climits>
#include <algorithm>
#include <cmath>
#define INF (INT_MAX / 2)
//#define DEBUG true
#define DEBUG false
using namespace std;

int main(){
  ios::sync_with_stdio(false);
  cin.tie(0);

  int x1, y1, r, x2, y2, x3, y3;
  cin >> x1 >> y1 >> r;
  cin >> x2 >> y2 >> x3 >> y3;

  int lx = x1 - r, rx = x1 + r;
  int dy = y1 - r, uy = y1 + r;
  bool exist_red = false;
  if(!(x2 <= lx && lx <= x3 && y2 <= y1 && y1 <= y3)){
    exist_red = true;
  }
  else if(!(x2 <= x1 && x1 <= x3 && y2 <= dy && dy <= y3)){
    exist_red = true;
  }
  else if(!(x2 <= rx && rx <= x3 && y2 <= y1 && y1 <= y3)){
    exist_red = true;
  }
  else if(!(x2 <= x1 && x1 <= x3 && y2 <= uy && uy <= y3)){
    exist_red = true;
  }

  bool exist_blue = false;
  for(int x = x2; x <= x3; x++){
    for(int y = y2; y <= y3; y++){
      if((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y) > r * r){
        exist_blue = true;
        break;
      }
    }
  }

  if(exist_red){
    cout << "YES" << endl;
  }
  else{
    cout << "NO" << endl;
  }
  if(exist_blue){
    cout << "YES" << endl;
  }
  else{
    cout << "NO" << endl;
  }

  return 0;
}
