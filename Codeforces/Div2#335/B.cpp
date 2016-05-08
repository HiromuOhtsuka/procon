#include <iostream>
#include <string>
#include <map>
#define MAX_LEN 100000
using namespace std;

typedef pair< int, int > P;

int x, y, x0, y0;
string S;

int walk(int sx, int sy, int k){
  int len = S.length();
  bool flag = false;
  for(int i = 0; i < k; i++){
    int tmpx = sx, tmpy = sy;
    switch(S[i]){
      case 'U' : sx--; break;
      case 'D' : sx++; break;
      case 'L' : sy--; break;
      case 'R' : sy++; break;
    }
    if(!(1 <= sx && sx <= x && 1 <= sy && sy <= y)){
      if(flag){
        return i;
      }
      flag = true;
    }
  }
  return k;
}

int main(){
  cin >> x >> y >> x0 >> y0;
  cin >> S;

  int len = S.length();
  for(int i = 0; i <= len; i++){
    int ret = walk(x0, y0, i + 1);
    cout << ret << ((i == len - 1) ? '\n' : ' ');
    int tmpx = x0, tmpy = y0;
    if(i == len){
      continue;
    }
    switch(S[i]){
      case 'U' : tmpx--; break;
      case 'D' : tmpx++; break;
      case 'L' : tmpy--; break;
      case 'R' : tmpy++; break;
    }
    if(1 <= tmpx && tmpx <= x && 1 <= tmpy && tmpy <= y){
      x0 = tmpx, y0 = tmpy;
    }
  }

  return 0;
}
