#include <cstdio>
#define MAX_N 110000
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
    if(N == 0){
      return 0;
    }
    int sum = 0;
    int count = 0;
    for(int i = 2; i <= MAX_N; i++){
      if(!is_prime_n[i]){
        sum += i;
        ++count;
      }
      if(count >= N){
        break;
      }
    }
    printf("%d\n", sum);
  }

  return 0;
}
