#include <cstdio>
using namespace std;

static int N[5];

int main(){
  for(int i = 0; i < 5; i++){
    scanf("%d", &N[i]);
  }
  int tmp[10], sp = 0;
  for(int i = 0; i < 5; i++){
    for(int j = i + 1; j < 5; j++){
      for(int k = j + 1; k < 5; k++){
        tmp[sp++] = N[i] + N[j] + N[k];
      }
    }
  }

  for(int i = 0; i < 10; i++){
    int w = tmp[i], k = i;
    while(k - 1 >= 0 && tmp[k - 1] > w){
      tmp[k] = tmp[k - 1];
      --k;
    }
    tmp[k] = w;
  }

  printf("%d\n", tmp[7]);

  return 0;
}

