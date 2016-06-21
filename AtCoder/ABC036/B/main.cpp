nclude <iostream>
#include <cstdio>
using namespace std;

int main(){
  char S[51][51];
  int N;

  scanf("%d", &N);
  getchar();
  for(int i = 0; i < N; i++){
    for(int j = 0; j < N; j++){
      S[i][j] = getchar();
    }
    getchar();
  }

  for(int i = 0; i < N; i++){
    for(int j = N - 1; j >= 0; j--){
      printf("%c", S[j][i]);
    }
    putchar('\n');
  }
  return 0;
}
