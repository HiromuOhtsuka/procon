#include <cstdio>
using namespace std;

int main(){
  int a[4], b[4];
  int hit, blow;

  while(true){
    if(scanf("%d %d %d %d", &a[0], &a[1], &a[2], &a[3]) == EOF){
      break;
    }
    if(scanf("%d %d %d %d", &b[0], &b[1], &b[2], &b[3]) == EOF){
      break;
    }
    hit = blow = 0;
    for(int i = 0; i < 4; i++){
      for(int j = 0; j < 4; j++){
        if(b[j] == a[i]){
          if(i == j){
            hit++;
          }
          else{
            blow++;
          }
        }
      }
    }
    printf("%d %d\n", hit, blow);
  }

  return 0;
}
