#include <stdio.h>
#define MAX_W 5
#define MAX_H 5

int main(void){
  int n, table[MAX_H][MAX_W], w, h, i, j, k, l, x, y, flag;

  scanf("%d", &n);
  while(n){ // n回繰り返す
    // 入力
    for(i=0; i<MAX_H; i++){
      for(j=0; j<MAX_W; j++){
        scanf("%d", &table[i][j]);
      }
    }
    // 高さ：h 長さ：lの長方形を調べる。
    for(h=MAX_H; h>=0; h--){
      for(w=MAX_W; w>=0; w--){
        // 始点定める。
        for(y=0; y<MAX_H-h; y++){
          for(x=0; x<MAX_W-w; x++){
            flag = 1;
            for(k=y; k<y+h; k++){
              for(l=x; l<x+w; l++){
                if(!table[k][l]){
                  flag = 0; // サーチ終了。他の始点からサーチする
                  break;

    // 結果出力
    printf("%d\n",  w+h);
  }
  return 0;
}
