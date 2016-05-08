#include <cstdio>
using namespace std;

static bool is_prime(int n){
  for(int i = 2; i * i <= n; i++){
    if(n % i == 0){
      return false;
    }
  }
  return true;
}

int main(){
  int n;
  scanf("%d", &n);

  printf("%d:", n);
  for(int i = 2; i * i <= n; i++){
    if(is_prime(i)){
      while(n % i == 0){
        n /= i;
        printf(" %d", i);
      }
    }
  }
  if(n != 1){
    printf(" %d\n", n);
  }
  else{
    putchar('\n');
  }

  return 0;
}
