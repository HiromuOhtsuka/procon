#include <cstdio>
#define MAX_N 12
using namespace std;

static int N, S[MAX_N];
static int C[MAX_N];

int main(){
  for(;;){
    scanf("%d", &N);

    if(N == 0){
      return 0;
    }

    for(int i = 0; i < N; i++){
      scanf("%d", &S[i]);
    }

    int change_count = 0;
    bool not_p = true;
    while(not_p){
      for(int i = 0; i < N; i++){
        int count = 0;
        for(int j = 0; j < N; j++){
          if(S[i] == S[j]){
            ++count;
          }
        }
        C[i] = count;
      }
      ++change_count;
      not_p = false;
      for(int i = 0; i < N; i++){
        if(S[i] != C[i]){
          not_p = true;
          break;
        }
      }
      if(not_p){
        for(int i = 0; i < N; i++){
          S[i] = C[i];
        }
      }
    }

    printf("%d\n", change_count - 1);
    for(int i = 0; i < N; i++){
      printf("%d%c", C[i], i == N - 1 ? '\n' : ' ');
    }
  }

  return 0;
}
