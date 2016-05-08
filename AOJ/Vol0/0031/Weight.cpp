#include <cstdio>
using namespace std;

int main(){
  int w;
  while(scanf("%d", &w) != EOF){
    int ans[10], sp = 0;
    if(w - 512 >= 0){
      ans[sp++] = 512;
      w -= 512;
    }
    if(w - 256 >= 0){
      ans[sp++] = 256;
      w -= 256;
    }
    if(w - 128 >= 0){
      ans[sp++] = 128;
      w -= 128;
    }
    if(w - 64 >= 0){
      ans[sp++] = 64;
      w -= 64;
    }
    if(w - 32 >= 0){
      ans[sp++] = 32;
      w -= 32;
    }
    if(w - 16 >= 0){
      ans[sp++] = 16;
      w -= 16;
    }
    if(w - 8 >= 0){
      ans[sp++] = 8;
      w -= 8;
    }
    if(w - 4 >= 0){
      ans[sp++] = 4;
      w -= 4;
    }
    if(w - 2 >= 0){
      ans[sp++] = 2;
      w -= 2;
    }
    if(w - 1 >= 0){
      ans[sp++] = 1;
      w -= 1;
    }
    for(int i = sp - 1; i > 0; i--){
      printf("%d ", ans[i]);
    }
    printf("%d\n", ans[0]);
  }
  return 0;
}
