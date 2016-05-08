#include <cstdio>
#define N 30
using namespace std;

static bool submit[N + 1];

int main(){
  for(int i = 0; i < N - 2; i++){
    int num;
    scanf("%d", &num);
    submit[num] = true;
  }
  for(int i = 1; i <= N; i++){
    if(!submit[i]){
      printf("%d\n", i);
    }
  }

  return 0;
}
