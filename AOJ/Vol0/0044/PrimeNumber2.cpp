#include <cstdio>
#define MAX_N 50021
using namespace std;

static int N;
static bool is_prime_n[MAX_N + 1];

int main(){
  is_prime_n[0] = is_prime_n[1] = true;

  for(int i = 2; i <= MAX_N; i++){
    if(!is_prime_n[i]){
      for(int j = 2; i * j <= MAX_N; j++){
        is_prime_n[i * j] = true;
      }
    }
  }

  while(scanf("%d", &N) != EOF){
    for(int i = N - 1; i >= 0; i--){
      if(!is_prime_n[i]){
        printf("%d ", i);
        break;
      }
    }
    for(int i = N + 1; i <= MAX_N; i++){
      if(!is_prime_n[i]){
        printf("%d\n", i);
        break;
      }
    }
  }

  return 0;
}
