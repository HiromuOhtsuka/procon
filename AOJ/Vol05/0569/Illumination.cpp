#include <iostream>
#define MAX_W 100
#define MAX_H 100
using namespace std;

int W, H, table[MAX_H + 2][MAX_W + 2];
int sum;
void dfs(int x, int y){
  if(!(0 <= x && x < W + 2 && 0 <= y && y < H + 2)){
    return;
  }
  if(table[y][x] == 2){
    return;
  }
  if(table[y][x] == 1){
    sum++;
    return;
  }
  table[y][x] = 2;
  dfs(x + 1, y);
  dfs(x, y + 1);
  if(y % 2){
    dfs(x + 1, y + 1);
    dfs(x + 1, y - 1);
    dfs(x, y - 1);
    dfs(x - 1, y);
  }
  else{
    dfs(x - 1, y + 1);
    dfs(x - 1, y);
    dfs(x - 1, y - 1);
    dfs(x, y - 1);
  }
}

int main(){
  cin >> W >> H;
  for(int i = 1; i <= H; i++){
    for(int j = 1; j <= W; j++){
      cin >> table[i][j];
    }
  }

  for(int i = 0; i < H + 2; i++){
    if(table[i][0] != 2){
      dfs(0, i);
    }
    if(table[i][W + 1] != 2){
      dfs(W + 1, i);
    }
  }

  dfs(0, 0);

  cout << sum << endl;

  return 0;
}
