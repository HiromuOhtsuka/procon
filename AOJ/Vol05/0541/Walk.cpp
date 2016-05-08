#include <iostream>
#define MAX_H 1000
#define MAX_W 1000
#define MAX_N 10000000
using namespace std;

int H, W, N, table[MAX_H][MAX_W];

int main(){
  for(;;){
    cin >> H >> W >> N;

    if(H == 0 && W == 0 && N == 0){
      return 0;
    }

    for(int i = 0; i < H; i++){
      for(int j = 0; j < W; j++){
        cin >> table[i][j];
      }
    }

    int x = 0, y = 0, base = 1;
    for(;;){
      if(((N - 1) % base) % 2){
        table[y][x] = ((table[y][x] == 1) ? 0 : 1);
      }
      if(table[y][x]){
        x++;
      }
      else{
        y++;
      }
      if(y == H || x == W){
        break;
      }
      base <<= 1;
    }

    cout << (y + 1) << " " << (x + 1) << endl;
  }

  return 0;
}
