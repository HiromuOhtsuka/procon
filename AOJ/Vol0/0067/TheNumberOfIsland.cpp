#include <cstdio>
#include <iostream>
#include <string>
using namespace std;

static const int BLACK = 1, WHITE = 0;
static int table[12][12];
static bool dfs(int sx, int sy){
  if(!(0 <= sx && sx < 12 && 0 <= sy && sy < 12)){
    return false;
  }
  if(table[sy][sx] == WHITE){
    return false;
  }
  table[sy][sx] = WHITE;
  dfs(sx + 1, sy);  dfs(sx - 1, sy);
  dfs(sx, sy + 1);  dfs(sx, sy - 1);
  return true;
}

int main(){
  while(true){
    int ln = 0;
    string str;
    while(ln < 12 && getline(cin, str) && str.size() != 0){
      const char *s = str.c_str();
      for(int i = 0; i < 12; i++){
        table[ln][i] = s[i] - '0';
      }
      ++ln;
    }
    if(cin.eof()){
      return 0;
    }
    if(ln != 12){
      continue;
    }
    int count = 0;
    for(int i = 0; i < 12; i++){
      for(int j = 0; j < 12; j++){
        if(dfs(i, j)){
          ++count;
        }
      }
    }
    printf("%d\n", count);
  }

  return 0;
}

